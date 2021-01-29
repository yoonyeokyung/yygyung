package mini;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class MemberManager {
	
	public static int memberNumber= 0 ;
	
	
	
		public void Join(String id ,String pwd , String name ,String addr , String birthDate ,String gender) { //회원가입
			
			MemberDB memberDB = new MemberDB();	
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			String signupDate = date.format(new Date());
	
				Member user = new Member(id, pwd, name, addr, birthDate, gender, signupDate, " ", " ", 0);
//				System.out.println(user.toString());
				
				memberDB.memberUpdate(user);
//				memberDB.loadingDBMethod();
//				System.out.println("저장 디비" + memberDB.getListDB());
			
		}
		
		
		public void idCheck(String id) { //아이디체크
				
							 	
				if(id.isBlank()) {
			 		JOptionPane.showInternalMessageDialog(null, "아이디를 입력하세요");
							
				
				}else {
					boolean isTrue = true;
					for(int j = 0 ; j < MemberDB.listDB.size(); j ++ ) {
						if (id.equals(MemberDB.listDB.get(j).getId())) {
							JOptionPane.showInternalMessageDialog(null, "동일한 아이디가 존재합니다.");
							isTrue = false;
							break;
							}
						
						}
					
					if(isTrue) {
					JOptionPane.showInternalMessageDialog(null, "사용 가능한 아이디입니다.");

					}
				}
			
			}
		
		
		public boolean isBlankCheck(String id, String pwd, String name, String birthDate, String addr) {// 공란체크
		
		boolean isTrue = true;
		if((id.isBlank()) == true || (pwd.isBlank()) == true || (name.isBlank()) == true ||
		 (birthDate.isBlank()) == true || (addr.isBlank()) == true ) {
	
				JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.\n정보를 모두 입력하셔야합니다.");
				isTrue = false;
			}
			return isTrue;
		}
		
		public boolean pwdCheck(String pwd1 , String pwd2) { //비번체크
			
			
			boolean isTrue = true;
			if(!(pwd1.equals(pwd2))) {
				JOptionPane.showInternalMessageDialog(null, "비밀번호가 일치하지 않습니다.");
				isTrue = false;
			}
			return isTrue;
			
		}
		
		
		public boolean birthDateCheck(String BirthDate) { //생년월일 체크
			
			boolean isTrue = true;
			for(int j = 0 ; j < BirthDate.length() ; j++) {
				char ch = BirthDate.charAt(j);
				if(!((ch >= '0' &&  ch <= '9') && BirthDate.length() == 8 )) {
					
					JOptionPane.showInternalMessageDialog(null, "생년월일을 잘못입력하셧습니다. ex)19920513");
					isTrue = false;
					break;
				}
			}
			
			return isTrue;
			
		}
		
	


		public boolean login(String id ,String pwd) { //로그인 

			boolean idTrue = false;
			boolean pwdTrue = false;
			
			for(int i = 0 ; i < MemberDB.listDB.size() ; i ++ ) { 
				
				if (id.equals(MemberDB.listDB.get(i).getId()) ) {// ArrayList 에 저장한 회원정보에서 아이디 비교 
					idTrue = true;
					if(pwd.equals(MemberDB.listDB.get(i).getPwd())) {// ArrayList 아이디와 같은 인데스 비번도 동일하면 로그인  
						JOptionPane.showInternalMessageDialog(null, "로그인 되었습니다.");
						MemberManager.memberNumber = i;
						pwdTrue = true;
						break ;
						
					}else {
						JOptionPane.showInternalMessageDialog(null, "비밀번호가 틀렸습니다.");
					}
				}
			}
			
			if(idTrue == false) { // ArrayList 에 저장한 회원정보에서 아이디 비교해서 틀리면 아이디가 존재 x 출력
				JOptionPane.showInternalMessageDialog(null, "아이디가 존재하지 않습니다. 회원가입하세요");
			}
			return pwdTrue;
		}
		
		
		public void Info( ) {
			
			
		}
		
		public void MemberDelete() { //회원 탈퇴
			
			MemberDB memberDB = new MemberDB();
			

			MemberDB.listDB.remove(MemberManager.memberNumber);
			memberDB.informationChang();
			JOptionPane.showInternalMessageDialog(null, "탈퇴되었습니다. 다시오지마세요");

		}
		
		public boolean EditInfopwd(String id , String BirthDate) {//비번 변경전 정보확인
			

				boolean isTrue = false ;
				if(id.equals(MemberDB.listDB.get(MemberManager.memberNumber).getId())) {
					if(BirthDate.equals(MemberDB.listDB.get(MemberManager.memberNumber).getBirthDate())) {
						isTrue = true;
					}else {
						JOptionPane.showInternalMessageDialog(null, "생년월일이 틀렸습니다.");
						
					}
					
				}else {
					JOptionPane.showInternalMessageDialog(null, "아이디가 틀렸습니다.");
					
				}
			
			return isTrue;
			
		}
		
		
		public boolean changedPwd(String pwd1 , String pwd2) { //비번변경

			boolean isTrue = false ;
			
			if(pwd1.equals(pwd2)) {
				
				MemberDB.listDB.get(MemberManager.memberNumber).setPwd(pwd1);
				MemberDB memberDB = new MemberDB();
				memberDB.informationChang();
				isTrue = true;
				
				JOptionPane.showInternalMessageDialog(null, "비밀번호가 변경되었습니다.");
				
			}else {
				JOptionPane.showInternalMessageDialog(null, "비밀번호가 일치하지 않습니다.");
				
			}
			
			
			return isTrue;
			
		}
		
		public boolean resvervation(int revPrice ,String revTime) {

			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			String revDate = date.format(new Date());
			MemberDB memberDB = new MemberDB();
			
			boolean isTrue = true;
			
			for(int i = 0 ; i < MemberDB.listDB.size() ; i++) {
				
				
				if(MemberDB.listDB.get(i).getRevTime().equals(revTime)){
					isTrue = false;
					System.out.println("예약있음");
				}
			}
				
				if(isTrue){
					System.out.println("예약없음");
					MemberDB.listDB.get(MemberManager.memberNumber).setRevDate(revDate);
					MemberDB.listDB.get(MemberManager.memberNumber).setRevTime(revTime);
					MemberDB.listDB.get(MemberManager.memberNumber).setPrice(revPrice * 1000);
					
					memberDB.informationChang();
//					System.out.println("변경되값 " + MemberDB.listDB.get(MemberManager.memberNumber));
					memberDB.loadingDBMethod();
//					System.out.println("변경후 로딩 :" + MemberDB.listDB.get(MemberManager.memberNumber));
					
				}
				
			
			return isTrue;

		}
		
		
		public void resvervationCancel() { //예약취소
			MemberDB memberDB = new MemberDB();
			
			MemberDB.listDB.get(MemberManager.memberNumber).setRevDate(" ");
			MemberDB.listDB.get(MemberManager.memberNumber).setRevTime(" ");
			MemberDB.listDB.get(MemberManager.memberNumber).setPrice(0);
			memberDB.informationChang();
			memberDB.loadingDBMethod();
		}


}
