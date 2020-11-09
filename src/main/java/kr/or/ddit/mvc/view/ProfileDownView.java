package kr.or.ddit.mvc.view;

import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;


public class ProfileDownView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// response content-type 설정
		response.setHeader("Content-Disposition", "attachment; filename=\"\"" + (String)model.get("filepath") + "\"");
		response.setContentType("application/octet-stream");

		// 경로 확인 후 파일 입추력을 통해 응답생성
		// 파일 읽기
		// 파일 생성
		FileInputStream fis = new FileInputStream((String)model.get("filepath"));
		ServletOutputStream sos = response.getOutputStream();

		byte[] buffer = new byte[512];

		while (fis.read(buffer) != -1) {
			sos.write(buffer);
		}

		fis.close();
		sos.flush();
		sos.close();

	}

}
