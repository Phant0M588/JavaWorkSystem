import java.io.*;
import java.net.URL;
import java.util.Scanner;
import javazoom.jl.player.Player;

void main() {
    String imageUrl = "";
    String imagePath = "";
    String mp3Url = "";
    String mp3Path = "";
    try (Scanner scanner = new Scanner(new File("input.txt"))) {
        // Читаем первую строку (картинка)
        if (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(" ");
            if (parts.length >= 2) {
                imageUrl = parts[0];
                imagePath = parts[1];
            }
        }
        if (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(" ");
            if (parts.length >= 2) {
                mp3Url = parts[0];
                mp3Path = parts[1];
            }
        }
    } catch (FileNotFoundException e) {
        System.out.println("ОШИБКА: Файл input.txt не найден!");
        return;
    }
    System.out.println("Паралельное скачивание.");
    final String finalImageUrl = imageUrl;
    final String finalImagePath = imagePath;
    final String finalMp3Url = mp3Url;
    final String finalMp3Path = mp3Path;
    Thread imageThread = new Thread(() -> {
        try {
            download(finalImageUrl, finalImagePath);
            System.out.println("[ПОТОК КАРТИНКИ] Готово! Картинка скачана.");
        } catch (Exception e) {
            System.out.println("[ПОТОК КАРТИНКИ] ОШИБКА: " + e.getMessage());
        }
    });
    Thread musicThread = new Thread(() -> {
        try {
            download(finalMp3Url, finalMp3Path);
            System.out.println("[ПОТОК МУЗЫКИ] Готово! Музыка скачана.");
        } catch (Exception e) {
            System.out.println("[ПОТОК МУЗЫКИ] ОШИБКА: " + e.getMessage());
        }
    });
    imageThread.start();
    musicThread.start();
    try {
        musicThread.join();
        System.out.println("\nВоспроизводим скачанную музыку.");
        playMusic(mp3Path);
    } catch (InterruptedException e) {
        System.out.println("Скачивание музыки было прервано: " + e.getMessage());
    }
}

public static void download(String urlString, String fileName) throws IOException {
    URL url = new URL(urlString);
    BufferedInputStream in = new BufferedInputStream(url.openStream());
    FileOutputStream out = new FileOutputStream(fileName);
    try {
        byte[] data = new byte[1024];
        int count;
        while ((count = in.read(data, 0, 1024)) != -1) {
            out.write(data, 0, count);
        }
    } finally {
        if (in != null) in.close();
        if (out != null) out.close();
    }
}

public static void playMusic(String mp3FilePath) {
    try {
        FileInputStream fis = new FileInputStream(mp3FilePath);
        Player player = new Player(fis);
        player.play();
    } catch (Exception e) {
        System.out.println("Ошибка воспроизведения: " + e.getMessage());
    }
}