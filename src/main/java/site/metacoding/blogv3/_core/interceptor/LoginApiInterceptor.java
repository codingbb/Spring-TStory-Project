package site.metacoding.blogv3._core.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import site.metacoding.blogv3._core.exception.ApiException401;
import site.metacoding.blogv3._core.exception.Exception401;
import site.metacoding.blogv3._core.util.ApiUtil;
import site.metacoding.blogv3.user.User;

public class LoginApiInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("되는가 ");
        HttpSession session = request.getSession();

        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null) {
            writeErrorResponse(response, "로그인이 필요한 서비스입니다.");
            return false; // False to stop the processing of the request
        }

        return true;
    }

    private void writeErrorResponse(HttpServletResponse response, String message) throws Exception {
        ApiUtil apiUtil = new ApiUtil(401, message);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(apiUtil);

        response.setContentType("application/json; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(jsonResponse);
    }
}
