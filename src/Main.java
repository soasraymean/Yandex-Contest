import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        char[][] layout = new char[n][7];
        for (int i = 0; i < n; i++) {
            String data = "";
            data = in.nextLine();
            data = data.trim();
            layout[i] = data.toCharArray();
        }
        int m = Integer.parseInt(in.nextLine());
        String[] requests = new String[m];
        for (int i = 0; i < m; i++) {
            requests[i] = in.nextLine();
        }

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(requests[i].substring(0, 1));
            String side = requests[i].substring(2, 7).trim();
            String position = requests[i].substring(7).trim();
            boolean f = false;
            int row = 0;
            char[] cols = new char[num];
            switch (side) {
                case "left":
                    if ("window".equals(position)) {
                        for (int j = 0; j < n; j++) {
                            for (int k = 0; k < 1; k++) {
                                if (layout[j][k] == '.') {
                                    switch (num) {
                                        case 1:
                                            layout[j][k] = 'X';
                                            f = true;
                                            int kk = k+1;
                                            row = j;
                                            for (int l = 0; l < num; l++) {

                                                cols[l] = (char) kk;
                                                kk++;
                                            }
                                            break;
                                        case 2:
                                            if (layout[j][k + 1] == '.') {
                                                layout[j][k] = 'X';
                                                layout[j][k + 1] = 'X';
                                                f = true;
                                                row = j;
                                                kk = k+1;
                                                for (int l = 0; l < num; l++) {

                                                    cols[l] = (char) kk;

                                                    kk++;
                                                }
                                            }
                                            break;
                                        case 3:
                                            if (layout[j][k + 1] == '.' && layout[j][k + 2] == '.') {
                                                layout[j][k] = 'X';
                                                layout[j][k + 1] = 'X';
                                                layout[j][k + 2] = 'X';
                                                f = true;
                                                row = j;
                                                kk = k+1;
                                                for (int l = 0; l < num; l++) {

                                                    cols[l] = (char) kk;

                                                    kk++;
                                                }
                                            }
                                            break;
                                    }
                                }
                                if (f) break;
                            }
                            if (f) break;
                        }
                    } else if ("aisle".equals(position)) {
                        for (int j = 0; j < n; j++) {
                            for (int k = 2; k < 3; k++) {
                                if (layout[j][k] == '.') {
                                    switch (num) {
                                        case 1:
                                            layout[j][k] = 'X';
                                            f = true;
                                            row = j;
                                            int kk = k+1;
                                            for (int l = 0; l < num; l++) {
                                                cols[l] = (char) kk;
                                                kk--;
                                            }
                                            break;
                                        case 2:
                                            if (layout[j][k - 1] == '.') {
                                                layout[j][k] = 'X';
                                                layout[j][k - 1] = 'X';
                                                f = true;
                                                row = j;
                                                kk = k+1;
                                                for (int l = 0; l < num; l++) {
                                                    cols[l] = (char) kk;
                                                    kk--;
                                                }
                                            }
                                            break;
                                        case 3:
                                            if (layout[j][k - 1] == '.' && layout[j][k - 2] == '.') {
                                                layout[j][k] = 'X';
                                                layout[j][k - 1] = 'X';
                                                layout[j][k - 2] = 'X';
                                                f = true;
                                                row = j;
                                                kk = k+1;
                                                for (int l = 0; l < num; l++) {
                                                    cols[l] = (char) kk;
                                                    kk--;
                                                }
                                            }
                                            break;
                                    }
                                }
                                if (f) break;
                            }
                            if (f) break;
                        }
                    }
                    if (f) {
                        Arrays.sort(cols);
                        System.out.print("Passengers can take seats: ");
                        for (int j = 0; j < num - 1; j++) {
                            System.out.print(row + 1);
                            System.out.print((char) (cols[j] + 64) + " ");
                        }
                        System.out.print(row + 1);
                        System.out.println((char) (cols[num - 1] + 64));
                        for (int j = 0; j < n; j++) {
                            for (int k = 0; k < 7; k++) {
                                System.out.print(layout[j][k]);
                                if (layout[j][k] == 'X') {
                                    layout[j][k] = '#';
                                }
                            }
                            System.out.println();
                        }
                    } else {
                        System.out.println("Cannot fulfill passengers requirements");
                    }
                    break;
                case "right":
                    if ("window".equals(position)) {
                        for (int j = 0; j < n; j++) {
                            for (int k = 6; k < 7; k++) {
                                if (layout[j][k] == '.') {
                                    switch (num) {
                                        case 1:
                                            layout[j][k] = 'X';
                                            f = true;
                                            int kk = k;
                                            row = j;
                                            for (int l = 0; l < num; l++) {
                                                cols[l] = (char) kk;
                                                kk--;
                                            }
                                            break;
                                        case 2:
                                            if (layout[j][k - 1] == '.') {
                                                layout[j][k] = 'X';
                                                layout[j][k - 1] = 'X';
                                                f = true;
                                                row = j;
                                                kk = k;
                                                for (int l = 0; l < num; l++) {
                                                    cols[l] = (char) kk;
                                                    kk--;
                                                }
                                            }
                                            break;
                                        case 3:
                                            if (layout[j][k - 1] == '.' && layout[j][k - 2] == '.') {
                                                layout[j][k] = 'X';
                                                layout[j][k - 1] = 'X';
                                                layout[j][k - 2] = 'X';
                                                f = true;
                                                row = j;
                                                kk = k;
                                                for (int l = 0; l < num; l++) {
                                                    cols[l] = (char) kk;
                                                    kk--;
                                                }
                                            }
                                            break;
                                    }
                                }
                                if (f) break;
                            }
                            if (f) break;
                        }
                    } else if ("aisle".equals(position)) {
                        for (int j = 0; j < n; j++) {
                            for (int k = 4; k < 5; k++) {
                                if (layout[j][k] == '.') {
                                    switch (num) {
                                        case 1:
                                            layout[j][k] = 'X';
                                            f = true;
                                            row = j;
                                            int kk = k;
                                            for (int l = 0; l < num; l++) {
                                                cols[l] = (char) kk;
                                                kk++;
                                            }
                                            break;
                                        case 2:
                                            if (layout[j][k + 1] == '.') {
                                                layout[j][k] = 'X';
                                                layout[j][k + 1] = 'X';
                                                f = true;
                                                row = j;
                                                kk = k;
                                                for (int l = 0; l < num; l++) {
                                                    cols[l] = (char) kk;
                                                    kk++;
                                                }
                                            }
                                            break;
                                        case 3:
                                            if (layout[j][k + 1] == '.' && layout[j][k + 2] == '.') {
                                                layout[j][k] = 'X';
                                                layout[j][k + 1] = 'X';
                                                layout[j][k + 2] = 'X';
                                                f = true;
                                                row = j;
                                                kk = k;
                                                for (int l = 0; l < num; l++) {
                                                    cols[l] = (char) kk;
                                                    kk++;
                                                }
                                            }
                                            break;
                                    }
                                }
                                if (f) break;
                            }
                            if (f) break;
                        }
                    }
                    if (f) {
                        Arrays.sort(cols);
                        System.out.print("Passengers can take seats: ");
                        for (int j = 0; j < num - 1; j++) {
                            System.out.print(row + 1);
                            System.out.print((char) (cols[j] + 64) + " ");
                        }
                        System.out.print(row + 1);
                        System.out.println((char) (cols[num - 1] + 64));
                        for (int j = 0; j < n; j++) {
                            for (int k = 0; k < 7; k++) {
                                System.out.print(layout[j][k]);
                                if (layout[j][k] == 'X') {
                                    layout[j][k] = '#';
                                }
                            }
                            System.out.println();
                        }
                    } else {
                        System.out.println("Cannot fulfill passengers requirements");
                    }
                    break;

            }

        }
    }
}