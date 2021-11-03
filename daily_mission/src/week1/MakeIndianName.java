package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeIndianName {
    public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("생년월일을 입력해 주세요> ");
        int birth = Integer.parseInt(br.readLine());

    }
    public static void main(String[] args) {
        String[] yearNames = {"시끄러운","푸른","어두운","조용한", "웅크린",
                "백색", "지혜로운","용감한","날카로운","욕심많은"};
        String[] monthNames = {"늑대","태양","양","매", "황소",
                "불꽃", "나무", "달빛", "말", "돼지", "하늘", "바람"};
        String[] dayNames = {"와(과) 함께 춤을", "의 기상", "은(는) 그림자 속에", "", "", "",
                "의 환생", "의 죽음", "아래에서", "를(을) 보라", "이(가) 노래하다.", "그림자",
                "의 일격", "에게 쫒기는 남자(여자)", "의 행진", "의 왕", "의 유령",
                "을(를) 죽인자", "는(은) 맨날 잠잔다.", "처럼", "의 고향", "의 전사",
                "은(는) 나의 친구", "의 노래", "의 정령", "의 파수꾼", "의 악마",
                "와(과) 같은 사나이(아가씨)", "를(을) 쓰러트린 자", "의 혼", "는(은) 말이 없다."};

    }
}
