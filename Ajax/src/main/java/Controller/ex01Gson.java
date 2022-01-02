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
		
		MemberVO vo1 = new MemberVO("�̸�1", "12345", "010-1234-1134", "���� ����");
		MemberVO vo2 = new MemberVO("�̸�2", "22345", "010-1234-1134", "���� ����");
		MemberVO vo3 = new MemberVO("�̸�3", "32345", "010-1234-1134", "���� ����");
		MemberVO vo4 = new MemberVO("�̸�4", "42345", "010-1234-1134", "���� ����");
		
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		// �ܼ� ��������
		
		// 1. ������� ������ �޾ƿ���
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name"); // data�� key��
		System.out.println(name);
		
		// 2. json������ ����
		// Gson ��ü ����
		Gson gson = new Gson();
		
		// Gson�� toJson�޼��� �̿��ؼ� ArrayList > Json
		String json = gson.toJson(list);
		
		// �ڵ����� field ������ �̸����� key���� ����
		System.out.println(json);
		
		// ����
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(json);
		
		
		
		
	}

}
