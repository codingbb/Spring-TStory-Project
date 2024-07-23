package site.metacoding.blogv3._core.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import site.metacoding.blogv3._core.util.ApiUtil;
import site.metacoding.blogv3._core.util.CachedBodyHttpServletRequest;
import site.metacoding.blogv3.reply.Reply;
import site.metacoding.blogv3.reply.ReplyRequest;

import java.io.IOException;

public class TrashFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

//        System.out.println("3333333333333333");

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

//        System.out.println("111 fdsaafdssssssssssssssss");
//        System.out.println("222 request.getMethod() : " + request.getMethod());

        CachedBodyHttpServletRequest cachedBodyHttpServletRequest = new CachedBodyHttpServletRequest(request);

        // comment, postId
        if (request.getMethod().equals("POST") || request.getMethod().equals("PUT")) {
            ObjectMapper om = new ObjectMapper();
//            System.out.println("333 되낭요>?>");

            //http request 에서 json 데이터 읽어오고 (ObjectMapper) ReplyRequest.SaveDTO 클래스 객체로 변환
//            ReplyRequest.SaveDTO requestBody = om.readValue(request.getInputStream(), ReplyRequest.SaveDTO.class);
            ReplyRequest.DTO requestBody = om.readValue(cachedBodyHttpServletRequest.getInputStream(), ReplyRequest.DTO.class);
//            System.out.println("444 requestBody : " + requestBody);

            if (requestBody.getComment().contains("바보")) {
//                System.out.println("555 타니???????????????");

                response.setContentType("application/json; charset=utf-8");
                ApiUtil apiUtil = new ApiUtil(400, "욕설 및 비하 발언은 허용되지 않습니다.");
//                System.out.println("666 apiUtil ㅠㅠ = " + apiUtil);
                String responseBody = om.writeValueAsString(apiUtil);

//                System.out.println("777 responseBody 되나되나 = " + responseBody);

                response.getWriter().println(responseBody);
                return;
            }

        }

//        System.out.println("88888??");

        chain.doFilter(cachedBodyHttpServletRequest, response);

    }
}
