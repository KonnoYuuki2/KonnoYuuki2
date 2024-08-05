import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.filechooser.FileNameExtensionFilter;


//경로를 불러오나 그 경로에 "\"가 있어서 txt.java나 jFile.java의 경로에서 사용할 수 없는 문제가 생김

public class infe extends JFrame {
  String SaveFileChecker = new String();
  String OpenFileChecker = new String();
  StringBuilder OpenBuilder;
  StringBuilder SaveBuilder;
  int backSlash = 92; // "\" 아스키 코드값
  int slash = 47; // "/" 아스키 코드값
  int returnEnd = 0;

  public infe(){
    JButton OpenFileBT = new JButton("실행 파일 선택");
    JButton SaveFileBT = new JButton("저장 파일 선택");
    JButton InputBT = new JButton("저장 실행");

    JFileChooser OpenChooser = new JFileChooser();
    JFileChooser SaveChooser = new JFileChooser();
    FileNameExtensionFilter OpenFilter = new FileNameExtensionFilter("OpenFile(slk,j,txt) selector", "j","txt","slk"); 
    FileNameExtensionFilter SaveFilter = new FileNameExtensionFilter("SaveFile(txt) selector", "txt");
    JLabel OpenLabel = new JLabel("실행 파일 없음");
    JLabel SaveLabel = new JLabel("저장 파일 없음");
    
    //버튼 누르는 액션들
    OpenFileBT.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
           OpenChooser.setFileFilter(OpenFilter);
           int returnVal = OpenChooser.showOpenDialog(getParent());
           if(returnVal == JFileChooser.APPROVE_OPTION) {
            OpenBuilder = new StringBuilder(OpenChooser.getSelectedFile().getPath());
            OpenFileChecker = OpenChooser.getSelectedFile().getPath(); 
             OpenLabel.setText(OpenChooser.getSelectedFile().getPath());
           }
       }
    });


    SaveFileBT.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          SaveChooser.setFileFilter(SaveFilter);
          int returnVal = SaveChooser.showOpenDialog(getParent());

          if(returnVal == JFileChooser.APPROVE_OPTION) {
            SaveBuilder = new StringBuilder(SaveChooser.getSelectedFile().getPath());
            SaveFileChecker = SaveChooser.getSelectedFile().getPath(); 
            SaveLabel.setText(SaveChooser.getSelectedFile().getPath());
          }
      }
   });

   InputBT.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
     // System.out.println(OpenFileChecker.length());
     // System.out.println((char)backSlash);
      if((OpenFileChecker.lastIndexOf(".j") > 1) || (OpenFileChecker.lastIndexOf(".slk") > 1) ){
        for(int i = 0 ; i < OpenFileChecker.length(); i++) {
          if(OpenFileChecker.charAt(i) == (char)backSlash) {
            OpenBuilder.setCharAt(i, '/');
            //문자열 내의 문자를 바꾸는 방법을 깨달아야 한다.
          }

        }

        for(int i = 0 ; i < SaveFileChecker.length(); i++) {
          if(SaveFileChecker.charAt(i) == (char)backSlash) {
            SaveBuilder.setCharAt(i, '/');
            //문자열 내의 문자를 바꾸는 방법을 깨달아야 한다.
          }
        }

        OpenFileChecker = OpenBuilder.toString();
        SaveFileChecker = SaveBuilder.toString();
        System.out.println(SaveFileChecker);

        jFile.filePath = OpenFileChecker;
        jFile.SavePath = SaveFileChecker;
        jFile.jFileExe();

        returnEnd = 1;
      }
      else {
        for(int i = 0 ; i < OpenFileChecker.length(); i++) {
          if(OpenFileChecker.charAt(i) == (char)backSlash) {
            OpenBuilder.setCharAt(i, '/');
            //문자열 내의 문자를 바꾸는 방법을 깨달아야 한다.
          }

        }

        for(int i = 0 ; i < SaveFileChecker.length(); i++) {
          if(SaveFileChecker.charAt(i) == (char)backSlash) {
            SaveBuilder.setCharAt(i, '/');
            //문자열 내의 문자를 바꾸는 방법을 깨달아야 한다.
          }
        }
        OpenFileChecker = OpenBuilder.toString();
        SaveFileChecker = SaveBuilder.toString();

        System.out.println(OpenFileChecker);
        txt.filePath = OpenFileChecker;
        txt.SavePath = SaveFileChecker;

        txt.txtExe();


      }
    }
 });


 //전체적인 프레임 세팅
  setSize(new Dimension(750,300));
  setLayout(new FlowLayout(FlowLayout.CENTER,10,10));

  add(OpenFileBT);
  add(OpenLabel);  
  add(SaveFileBT);
  add(SaveLabel);  
  add(InputBT);


  setVisible(true);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  }

public static void main(String[] args) {
   new infe();
 }
} 
