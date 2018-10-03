package net.thjang.blog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
//    public List<String> showAll(ArrayList<String> chatList) {
//        return chatList;
//    }

    public static void main(String[] args) {
        String temp = null;
        String[] tempLines = new String[3];

        String[] record = new String[100000];
        int recordCount = 0;
//        StringBuffer[][] chatList;
        String userId = null;
        String userNickname = null;
        ArrayList<String> chatList = new ArrayList<>();
        ArrayList<Integer> recordNum = new ArrayList<>();
        HashMap<String, Integer> userLatest = new HashMap<>();
        String entLeaveChg = null;
        boolean entered = false;
        boolean leaved = false;
        Integer foundNumber;
        int chatNicknameNum = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("내용을 입력하십시오 : ");
        temp = scanner.nextLine();

        tempLines = temp.split(" ");
        switch (tempLines[0]) {
            case "Enter":
                entered = true;
                leaved = false;
                break;
            case "Leave":
                leaved = true;
                entered = false;
                break;
            case "Change":
                break;
            default:
                System.out.println("잘못된 값을 전달받았습니다.");
        }

        userId = tempLines[1];
        userNickname = tempLines[2];

        // 채팅방 최초 실행하고 입장하였거나, 처음 입장한 이용자인 경우
        if ((entered && userLatest.isEmpty())
                || (!(userLatest.containsKey(userId)))) {
            record[recordCount] = userNickname;
            userLatest.put(userId, recordCount);

//            chatList[0][chatNicknameNum].append(record[userLatest.get(tempLines[1])]);
            // 모든 채팅 출력
//            for (String chat : chatList) {
//                System.out.println(chat);
//            }
            recordCount++;
        }

        // 채팅방에 입장한 경우
        if (entered && !(userLatest.isEmpty())) {
            // HashMap에서 기존의 record 번호 조회
            foundNumber = userLatest.get(userId);
            // 한 User ID로부터 Nickname이 바뀐 경우(바뀌지 않으면 검사하지 않음)
            if (!(record[foundNumber].equals(userNickname))) {
                // record에 새로운 nickname을 넣고, record 갱신
                record[recordCount] = userNickname;
                userLatest.replace(userId, recordCount);
                // 변경 후 모든 채팅 출력
//                for (String chat : chatList) {
//                    System.out.println(chat);
//                }
                recordCount++;
            }
        }

        // 채팅방을 나갈 때
        if (leaved) {

            entered = leaved = false;
        }
    }
}
