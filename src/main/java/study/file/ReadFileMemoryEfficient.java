package study.file;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ReadFileMemoryEfficient {

    public static void main(String[] args) {
        String filePath = "/Users/Study/example/src/main/java/com/example/study/file/test.txt";
        File file = new File(filePath);
        long start = System.currentTimeMillis();
       /* try {
            Files.lines(Paths.get(filePath)).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        ByteBuffer buffer = ByteBuffer.allocate(100);
        Path path = Paths.get(filePath);
        int pos = 0;
        try {
            AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);

            while (true) {

                Future<Integer> result = fileChannel.read(buffer, pos);

                int blockRead = result.get();

                if (blockRead < 0) {
                    break;
                }

                pos += blockRead;

                buffer.flip();
                System.out.println(Charset.defaultCharset().decode(buffer));
                buffer.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(file.length());

    }


}
