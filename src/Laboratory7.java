import java.io.*;
import java.net.URL;
import java.util.Scanner;

void main() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ссылку на картинку: ");
    String url = scanner.nextLine().trim();
    System.out.print("Название: ");
    String fileName = scanner.nextLine().trim();
    if (url.isEmpty() || fileName.isEmpty()) {
        System.out.println("ОШИБКА: Пустая ссылка или имя файла!");
        return;
    }
    try {
        download(url, fileName);
        System.out.println("\nГОТОВО! Картинка сохранена.");
    }
    catch (Exception e) {
        System.out.println("\nОШИБКА: " + e.getMessage());
    }
}

public static void download(String urlString, String fileName) throws IOException {
    BufferedInputStream in = new BufferedInputStream(new URL(urlString).openStream());
    FileOutputStream out = new FileOutputStream(fileName);
    try {
        byte[] data = new byte[1024];
        int count;
        long total = 0;
        System.out.println("Скачивается");
        while ((count = in.read(data, 0, 1024)) != -1) {
            out.write(data, 0, count);
            total += count;
            System.out.print("\rСкачано: " + (total / 1024) + " КБ");
        }
        System.out.println(); // Перенос строки после окончания загрузки
    }
    finally
    {
        if (in != null) in.close();
        if (out != null) out.close();
    }
}
