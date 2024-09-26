class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int posMin = Integer.parseInt(pos.substring(0,2));
        int posSec = Integer.parseInt(pos.substring(3,5));
        int opStartMin = Integer.parseInt(op_start.substring(0,2));
        int opEndMin = Integer.parseInt(op_end.substring(0,2));
        int opStartSec = Integer.parseInt(op_start.substring(3,5));
        int opEndSec = Integer.parseInt(op_end.substring(3,5));
        int vidLenMin = Integer.parseInt(video_len.substring(0,2));
        int vidLenSec = Integer.parseInt(video_len.substring(3,5));
        
        
        for(int i=0; i<commands.length; i++) {
            
            //오프닝 건너뛰기
            if((posMin>opStartMin && posMin<opEndMin) || (posMin==opEndMin && posSec<=opEndSec && opEndMin>opStartMin) || (posMin==opStartMin && posSec >= opStartSec&& opEndMin>opStartMin) || (opStartMin==opEndMin && posMin == opStartMin && posSec>=opStartSec && posSec<=opEndSec)) {
            posMin = opEndMin;
            posSec = opEndSec;
            }
            
            //명령어 시작
            if(commands[i].equals("prev")) {
                if(posMin==0 && posSec<10) {
                    posMin = 0;
                    posSec = 0;
                } else {
                    if(posSec<10) {
                        posMin--;
                        posSec = 60 - (10 - posSec);
                    } else {
                        posSec-=10;
                    }
                }   
            } else if(commands[i].equals("next")) {
                if((posMin==vidLenMin&&posSec+10>vidLenSec) || (posSec+10>59&&posMin==vidLenMin) || (posSec+10>59 && posSec+10-60>vidLenSec && posMin+1==vidLenMin)) {
                    posMin = vidLenMin;
                    posSec = vidLenSec;
                } else {
                    if(posSec>50) {
                        posMin++;
                        posSec = (10 + posSec) - 60;
                    } else {
                        posSec+=10;
                    }
                }  
                
            } 
            System.out.println(posMin + " " + posSec);    
        }
        
        //오프닝 건너뛰기
        if((posMin>opStartMin && posMin<opEndMin) || (posMin==opEndMin && posSec<=opEndSec && opEndMin>opStartMin) || (posMin==opStartMin && posSec >= opStartSec&& opEndMin>opStartMin) || (opStartMin==opEndMin && posMin == opStartMin && posSec>=opStartSec && posSec<=opEndSec)) {
            posMin = opEndMin;
            posSec = opEndSec;
            }
     
        String strMin;
        String strSec;
        if(posMin<10) {
            strMin = "0" + posMin;
        } else {
            strMin = "" + posMin;
        }
        
        if(posSec<10) {
            strSec = "0" + posSec;
        } else {
            strSec = "" + posSec;
        }
        
        
        answer = strMin + ":" + strSec;
        
        return answer;
    }
}