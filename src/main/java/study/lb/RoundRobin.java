package study.lb;

import java.util.*;

public class RoundRobin {

    private static volatile Integer position = 0; // Starting position

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            System.out.println(getServer());
        }

    }

    //Weighted round robin
    public static String getServer() {

        Map<String, Integer> serverMap = new HashMap<>();
        serverMap.putAll(IpMap.serverWeightMap);

        Set<String> servers = serverMap.keySet();

        List<String> serverList = new ArrayList<>();

        for (String server : servers) {
            int weight = serverMap.get(server);
            for (int i = 0; i < weight; i++) {
                serverList.add(server);
            }
        }

        //round robin
        return doRoundRobin(serverList);
    }

    private static String doRoundRobin(List<String> serverList) {
        String server;
        synchronized (position) {
            if (position >= serverList.size()) {
                position = 0;
            }
            server = serverList.get(position);
            position++;
        }
        return server;
    }
}

