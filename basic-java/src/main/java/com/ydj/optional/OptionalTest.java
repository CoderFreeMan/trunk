package com.ydj.optional;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public class OptionalTest {

    public static void main(String[] args) {
        /*Set set = new HashSet();
        for (int i = 0; i < 10; i++) {
            set.add(i + "----" + UUID.randomUUID().toString());
        }
        set.add(null);
        option(set);*/
        byte[] download = download("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535865476763&di=b36447b79e4c5c0ee2cabfbfae9811c6&imgtype=0&src=http%3A%2F%2Fpic21.photophoto.cn%2F20111021%2F0007019930999844_b.jpg");
        File file = new File("/home/ydj/图片/a.jpg");
        try (OutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(download);
            outputStream.flush();
        } catch (Exception e) {
            System.out.println("异常");
        }
        System.out.println(download.length);

    }

    private static void option(Set set) {
        Optional.ofNullable(set).ifPresent(new Consumer<Set>() {
            @Override
            public void accept(Set set) {
                set.stream().forEach(item -> {
                    Optional.ofNullable(item).ifPresent(new Consumer<Object>() {
                        @Override
                        public void accept(Object s) {
                            System.out.println(s);
                        }
                    });
                });
            }
        });
    }

    private static byte[] download(String url) {
        return Optional.ofNullable(url).flatMap(new Function<String, Optional<InputStream>>() {
            @Override
            public Optional<InputStream> apply(String s) {
                try {
                    URL url = new URL(s);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    int responseCode = urlConnection.getResponseCode();
                    System.out.println("response code is -> " + responseCode);
                    return Optional.ofNullable(urlConnection.getInputStream());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return Optional.empty();
            }
        }).flatMap(new Function<InputStream, Optional<byte[]>>() {
            @Override
            public Optional<byte[]> apply(InputStream inputStream) {
                try {
                    byte[] b = new byte[1024];
                    ByteArrayOutputStream s = new ByteArrayOutputStream();
                    int read = inputStream.read(b);

                    while (read > 0) {
                        s.write(b, 0, read);
                        read = inputStream.read(b);
                        s.flush();
                    }

                    return Optional.of(s.toByteArray());

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return Optional.empty();
            }
        }).get();
    }


}
