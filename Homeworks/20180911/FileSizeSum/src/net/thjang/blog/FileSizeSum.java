package net.thjang.blog;

import java.io.File;

public class FileSizeSum {

    // 합을 저장 할 전역 변수 선언
    static long totalSum = 0L;

    // 재귀 디렉터리 탐색 함수 생성
    public static void getDirPath(File f) {
        // 현재 폴더의 파일 리스트 구하기
        File[] files = f.listFiles();

        // 디렉터리인지 아닌지 판별
        for (File file : files) {
            // 파일일 경우 크기를 구하여 합산
            if (!(file.isDirectory())) {
                System.out.println("File : " + file.getName() + " / " + file.length() + "bytes");
                totalSum += file.length();
            } else {
                // 디렉터리인 경우 새로운 경로를 넣어주고 다시 탐색하게 한다.
                System.out.println("DIR : " + file.getName() + " 디렉터리 하위 파일을 탐색합니다.");
                File newPathFile = new File(file.getAbsolutePath());
                getDirPath(newPathFile);
            }
        }

    }

    public static void main(String[] args){
        // 최초에는 현재 경로로 설정
        File file = new File(".");

        getDirPath(file);

        System.out.println("하위 디렉터리를 포함한 모든 파일의 크기 합 : " + totalSum + "byte");

    }
}
