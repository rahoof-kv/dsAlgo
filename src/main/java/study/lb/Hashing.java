package study.lb;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

//Dns based load balancing using hashing
public class Hashing {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        System.out.println(getServerWithRendezvousHashing("100.3.2.1"));
        System.out.println(getServerWithRendezvousHashing("121.3.2.2"));
        System.out.println(getServerWithRendezvousHashing("121.3.2.3"));
        System.out.println(getServerWithRendezvousHashing("166.3.2.4"));
        System.out.println(getServerWithRendezvousHashing("166.3.2.5"));
        System.out.println(getServerWithRendezvousHashing("196.3.2.6"));
        System.out.println(getServerWithRendezvousHashing("197.3.2.1"));


    }

    public static String getServer(String remoteIp) throws NoSuchAlgorithmException {

        // we maintain our own server map always.
        Map<String, Integer> serverMap = new HashMap<>();
        serverMap.putAll(IpMap.serverWeightMap);

        Set<String> servers = serverMap.keySet();
        List<String> serverList = new ArrayList<>(servers);

        int serverHash = hashCode(remoteIp);
        int serverPosition = serverHash % serverList.size();

        return serverList.get(serverPosition);
    }

    // This should be some industry standard hashing like BCrypt, SHA-1, MD5
    private static int hashCode(String remoteIp) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(remoteIp.getBytes());
        byte[] hash = md.digest();
        return Arrays.hashCode(hash);
    }

    public static String getServerWithWeightedHashing(String remoteIp) throws NoSuchAlgorithmException {

        // we maintain our own server map always.
        Map<String, Integer> serverMap = new HashMap<>();
        serverMap.putAll(IpMap.serverWeightMap);

        List<String> serverList = new ArrayList<>();
        for (String server : serverMap.keySet()) {
            int weight = serverMap.get(server);
            for (int i = 0; i < weight; i++) {
                serverList.add(server);
            }
        }

        int serverHash = Math.abs(hashCode(remoteIp)); // This should be some industry standard hashing like SHA-3
        int serverPosition = serverHash % serverList.size();

        return serverList.get(serverPosition);
    }


    public static String getServerWithRendezvousHashing(String remoteIp) throws NoSuchAlgorithmException {
        // we maintain our own server map always.
        Map<String, Integer> serverMap = new HashMap<>();
        serverMap.putAll(IpMap.serverWeightMap);

        List<String> serverList = new ArrayList<>();
        for (String server : serverMap.keySet()) {
            int weight = serverMap.get(server);
            for (int i = 0; i < weight; i++) {
                serverList.add(server);
            }
        }

        return getRendezvousScore(remoteIp, serverList);
    }

    private static String getRendezvousScore(String remoteIp, List<String> serverList) throws NoSuchAlgorithmException {
        String maxServer = null;
        Integer maxScore = null;
        for (String server : serverList) {
            Integer score = computeScore(server, remoteIp);
            if (maxScore == null || score > maxScore) {
                maxScore = score;
                maxServer = server;
            }
        }
        return maxServer;

    }

    private static Integer computeScore(String server, String remoteIp) throws NoSuchAlgorithmException {
        int serverHash = Math.abs(hashCode(server)); // This should be some industry standard hashing like MD5
        int remoteIpHash = Math.abs(hashCode(remoteIp));
        return (remoteIpHash * 13 + serverHash * 11) % 67;

    }

}

class IpMap {

    // This map is dynamic based on the health of servers
    public static Map<String, Integer> serverWeightMap = new HashMap<>();

    static {
        serverWeightMap.put("192.188.1.1", 2); //most powerful machine
        serverWeightMap.put("192.188.1.2", 2); // normal machine
        serverWeightMap.put("192.188.1.4", 2); // medium powerful machine
        serverWeightMap.put("192.188.1.5", 2); // normal machine
        serverWeightMap.put("192.188.1.7", 2); // medium powerful machine
        serverWeightMap.put("192.188.1.8", 2); // normal machine
    }

    //we might have some other implementation here to add / remove servers from this
    //dictionary


    /*
    *
      192.188.1.7
      192.188.1.7
      192.188.1.8
      192.188.1.8
      192.188.1.7
      192.188.1.2
      192.188.1.7
   * */
}