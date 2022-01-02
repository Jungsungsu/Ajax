package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Model.MemberVO;
@WebServlet("/ex01Gson")
public class ex01Gson extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberVO vo1 = new MemberVO("이름1", "12345", "010-1234-1134", "광주 서구");
		MemberVO vo2 = new MemberVO("이름2", "22345", "010-1234-1134", "광주 서구");
		MemberVO vo3 = new MemberVO("이름3", "32345", "010-1234-1134", "광주 서구");
		MemberVO vo4 = new MemberVO("이름4", "42345", "010-1234-1134", "광주 서구");
		
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		// 단순 가데이터
		
		// 1. 보내줬던 데이터 받아오기
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name"); // data의 key값
		System.out.println(name);
		
		// 2. json데이터 응답
		// Gson 객체 생성
		Gson gson = new Gson();
		
		// Gson의 toJson메서드 이용해서 ArrayList > Json
		String json = gson.toJson(list);
		
		// 자동으로 field 변수의 이름으로 key값을 설정
		System.out.println(json);
		
		// 응답
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(json);
		
		
		
		
	}

}
