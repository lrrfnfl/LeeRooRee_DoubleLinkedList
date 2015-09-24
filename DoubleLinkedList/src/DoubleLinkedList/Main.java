package DoubleLinkedList;

import java.util.Scanner;

/**
 * Created by RooRee on 2015-09-22.
 */

public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int cnt = 0;
        LinkedList<Object> dll = new LinkedList<Object>();
        Scanner sc = new Scanner(System.in);

        while (cnt != 5) {
            System.out.println();
            System.out.println("                     번호를 입력하세요.");
            System.out.println("1.노드추가  2.노드삭제  3.노드검색  4.리스트출력  5.프로그램종료");
            int num = sc.nextInt();
            cnt = num;
            switch (num) {
                case 1: {
                    System.out.print("추가 할 노드의 index값과  data값을 입력하세요(첫index는 0)");
                    int index = sc.nextInt();
                    Object input = sc.next();
                    dll.addNode(index, input);
                    break;
                }
                case 2: {
                    System.out.print("노드를 삭제 할 index값을 입력하세요(첫 index는 0) : ");
                    int index = sc.nextInt();
                    dll.deleteNode(index);
                    break;
                }
                case 3: {
                    System.out.print("검색 할 노드의 index값을 입력하세요(첫 index는 0) : ");
                    int index = sc.nextInt();
                    dll.searchNode(index);
                    break;
                }
                case 4: {
                    dll.printList();
                    break;
                }
                case 5: {
                    System.exit(0);
                }
                default: {
                    System.out.println("입력값이 잘못되었습니다.");
                    break;
                }
            }
        }
    }
}