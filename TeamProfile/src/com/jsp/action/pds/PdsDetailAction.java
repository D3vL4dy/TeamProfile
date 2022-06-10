package com.jsp.action.pds;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.controller.MakeFileName;
import com.jsp.dto.MemberVO;
import com.jsp.dto.PFileVO;
import com.jsp.dto.PdsVO;
import com.jsp.service.PdsService;

public class PdsDetailAction implements Action{

	private PdsService pdsService;
	
	public void setPdsService(PdsService pdsService) {
		this.pdsService = pdsService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/pds/detail";
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		String from = request.getParameter("from");
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		String loginUserId = loginUser.getId();
		
		try {
			PdsVO pds = null;
			if(from != null && from.equals("list")) {
				pds = pdsService.read(pno,loginUserId);
				url = "redirect:/pds/detail.do?pno="+pno;
			}else {
				pds = pdsService.getPds(pno);
			}
			
			List<PFileVO> renamedPfileList = MakeFileName.parseFileNameFromAttaches(pds.getPfileList(), "\\$\\$");
			pds.setPfileList(renamedPfileList);
			
			request.setAttribute("loginUser", loginUser);
			request.setAttribute("pds", pds);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return url;
	}

}
