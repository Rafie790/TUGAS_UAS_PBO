package org.example;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ToDoList toDoList = new ToDoList();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    markTaskAsDone();
                    break;
                case 4:
                    displayTasks();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("===== Aplikasi To-Do List =====");
        System.out.println("1. Tambah Tugas");
        System.out.println("2. Hapus Tugas");
        System.out.println("3. Tandai Tugas Selesai");
        System.out.println("4. Tampilkan Daftar Tugas");
        System.out.println("5. Keluar");
        System.out.println("===============================");
    }

    private static int getUserChoice() {
        System.out.print("Masukkan pilihan: ");
        return scanner.nextInt();
    }

    private static void addTask() {
        scanner.nextLine(); // Membersihkan \n dari input sebelumnya

        System.out.print("Masukkan judul tugas: ");
        String title = scanner.nextLine();
        System.out.print("Masukkan deskripsi tugas: ");
        String description = scanner.nextLine();

        Task task = new Task(title, description);
        toDoList.addTask(task);
        System.out.println("Tugas berhasil ditambahkan.");
        System.out.println();
    }

    private static void removeTask() {
        System.out.print("Masukkan nomor tugas yang akan dihapus: ");
        int index = scanner.nextInt() - 1;

        toDoList.removeTask(index);
        System.out.println("Tugas berhasil dihapus.");
        System.out.println();
    }

    private static void markTaskAsDone() {
        System.out.print("Masukkan nomor tugas yang akan ditandai selesai: ");
        int index = scanner.nextInt() - 1;

        toDoList.markTaskAsDone(index);
        System.out.println("Tugas berhasil ditandai selesai.");
        System.out.println();
    }

    private static void displayTasks() {
        System.out.println("Daftar Tugas:");
        toDoList.displayTasks();
        System.out.println();
    }
}
