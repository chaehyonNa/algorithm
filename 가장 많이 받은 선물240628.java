class Solution {
    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[] giftnumbers = new int[friends.length];
        for(int i = 0; i < friends.length; i++){
            giftnumbers[i] = 0;
            for(String gift : gifts){       
                String[] splitStrings = gift.split(" ");
                if(splitStrings[0].equals(friends[i])){
                    giftnumbers[i]++;
                }
                if(splitStrings[1].equals(friends[i])){
                    giftnumbers[i]--;
                }
            }
            // System.out.println(giftnumbers[i]);
        }
        for(int i = 0; i < friends.length; i++){
            int giftPoint = 0; //freind가 다음달에 선물 받는 수
            for(int j = 0; j < friends.length; j++){

                if(i == j){
                    continue;
                }

                int compare = 0;
                for(String gift : gifts){       
                    String[] splitStrings = gift.split(" ");
                    if(splitStrings[0].equals(friends[i]) && splitStrings[1].equals(friends[j])){
                        compare++;
                    }
                    if(splitStrings[1].equals(friends[i]) && splitStrings[0].equals(friends[j])){
                        compare--;
                    }
                }
                
                if(compare>0){
                    giftPoint++;
                }else if(compare == 0){
                    if(giftnumbers[i]>giftnumbers[j]){
                        giftPoint++;
                    }
                }
            }
            // System.out.println(giftPoint);
            if(giftPoint>answer){
                answer = giftPoint;
            }
        }

        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args){
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        solution(friends, gifts);
    }
}