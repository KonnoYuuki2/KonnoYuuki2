import java.io.RandomAccessFile;
import java.io.FileWriter;



public class txt {
    static long fileCount = 0; //라인 수 세기
    static int SaveAsci = 61; // 아스키 코드 : = 
    static  String filePath; // 파일 경로
    static String SavePath;
    static String SaveOne; //가져온 한줄의 라인을 저장하기 위함
    static FileWriter Openfile2; //저장할 파일

    
   public static void txtExe(){ 
    try{
        System.out.println("오픈 파일 경로:" + filePath);
        System.out.println("저장 파일 경로:" + SavePath);
        RandomAccessFile RA = new RandomAccessFile(filePath, "r"); //파일패스의 경로에 있는 파일을 열고
        long fileLength = RA.length(); //파일의 길이 측정
        System.out.println(fileLength);

        int start = 0; // 처음 "이 나온 부분
        int end = 0; // 마지막에 "이 나온 부분
        int nullCount = 0;


            Openfile2 = new FileWriter(SavePath);
            System.out.println("파일이 열렸음");

            while(true) {
                    SaveOne = RA.readLine();
                    fileCount++;
                    //System.out.println("파일카운트:" + fileCount);
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
                        if((SaveOne.indexOf(".mdx")> 1)||(SaveOne.indexOf(".blp")> 1)
                        ||(SaveOne.indexOf(".tga")> 1)||(SaveOne.indexOf(".mdl")> 1)){//조건 가려내기
                            for(int i = 0; i < SaveOne.length(); i++) {
                                if(SaveOne.charAt(i) == (char)SaveAsci){
                                    start = i;
                                    end = SaveOne.length();
                                    break;
                                }
                                else {
                                    continue;
                                }
                            }
                            String SaveEnd = SaveOne.substring(start+1, end);

                            if((SaveOne.indexOf(".mdx")> 1)||(SaveOne.indexOf(".blp")> 1)
                            ||(SaveOne.indexOf(".tga")> 1)||(SaveOne.indexOf(".mdl")> 1)){
                               Openfile2.append(SaveEnd+"\n"); // \n 추가로 라인별로 정리
                            }
                        }
                }
                SaveOne = null;
            }

        RA.close();
        Openfile2.close();
        }
        catch(Exception e){
          System.out.println(e);
        }

    }
}

