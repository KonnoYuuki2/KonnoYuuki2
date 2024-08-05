import java.io.RandomAccessFile;
import java.io.FileWriter;


public class jFile {
  static long fileCount = 0; //라인 수 세기
  static int SaveAsci = 34; // 아스키 코드 : " 
  public static String filePath; // 파일 경로
  static String SaveOne; //가져온 한줄의 라인을 저장하기 위함
  static String SavePath;
  static FileWriter Openfile2; //저장할 파일
  
  public static void jFileExe() {
  try{
    System.out.println("오픈 파일 경로:" + filePath);
    System.out.println("저장 파일 경로:" + SavePath);

        RandomAccessFile RA = new RandomAccessFile(filePath, "r"); //파일패스의 경로에 있는 파일을 열고
        
        //System.out.println(RA.readLine());
        long fileLength = RA.length(); //파일의 길이 측정
        //System.out.println(fileLength);

        int AsciCount = 0; // " 가 나온 갯수
        int start = 0; // 처음 "이 나온 부분
        int end = 0; // 마지막에 "이 나온 부분
        int nullCount = 0;


        Openfile2 = new FileWriter(SavePath);
        System.out.println("파일이 열렸음");

          while(true)  {
                fileCount++;
                //System.out.println("파일 카운트:" + fileCount);
                //System.out.println(RA.readLine());
                SaveOne = RA.readLine();
                //System.out.println("널 카운트:" + nullCount);
                //System.out.println(SaveOne);
                if(SaveOne == null) {
                  nullCount++; 
                  if(nullCount == 100) {
                    break;
                  } 
                  else {
                    continue;
                  }              
                }
                else {
                  if((SaveOne.indexOf(".mdx")> 1)||(SaveOne.indexOf(".blp")> 1)||(SaveOne.indexOf(".mdl")> 1)||
                  (SaveOne.indexOf(".wav") > 1)||(SaveOne.indexOf(".mp3")> 1)||(SaveOne.indexOf(".tga")> 1)){//조건 가려내기
                    for(int i = 0; i < SaveOne.length(); i++) {
                      if(SaveOne.charAt(i) == (char)SaveAsci){
                        //Start에 확실한 조건 걸기, 다음에 "가 오는 점 부터 시작                
                        if(AsciCount == 0){
                          start = i;
                        }
                        else if(AsciCount == 1) {
                          end = i;
                          break;
                        }
                        AsciCount++;
                      }
                      else {
                        continue;
                      }
                    }

                    String SaveEnd = SaveOne.substring(start+1, end);

                    if((SaveEnd.indexOf(".mdx") > 1)||(SaveEnd.indexOf(".blp") > 1)||(SaveEnd.indexOf(".tga") > 1)
                    ||(SaveEnd.indexOf(".wav") > 1)||(SaveEnd.indexOf(".mp3") > 1)||(SaveEnd.indexOf(".mdl") > 1)){                   
                      Openfile2.append(SaveEnd+"\n"); // \n 추가로 라인별로 정리
                    }
                  } 
                }       
            AsciCount = 0;
            SaveOne = null;
        }
    //파일 닫고 마지막에 센 파일카운트 출력
    RA.close();
    Openfile2.close();
  }
  catch(Exception e){
    System.err.println(e);
    System.out.println("해당 파일이 존재하지 않습니다.");
  }  
  }
}
