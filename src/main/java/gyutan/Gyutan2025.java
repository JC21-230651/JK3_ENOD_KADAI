package gyutan;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apiClass.GetClu;

@WebServlet("/tan")
public class Gyutan2025 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Gyutan2025() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("doGet method.");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 受取ったパラメータの文字エンコードをUTF-8にする
		request.setCharacterEncoding("UTF-8");

		// パラメータを取得する
		String param = request.getParameter("param");
		// パラメータがnullなら、変数paramを""にする
		if(Objects.isNull(param)) {
			param="";
		}

		// paramを送ってCLUからデータを取得する
		String detected = GetClu.getLanguageText(param);

		
		// 結果（スキーム）をコンソールとWebブラウザにひょうじ
		System.out.println(detected);
        String nextPage;

        switch (detected) {
            case "MENU":
                nextPage = "/menu.jsp";
                break;

            case "SHOP":
                nextPage = "/shop.jsp";
                break;

            case "HISTORY":
                nextPage = "/history.jsp";
                break;

            case "ABOUT":
                nextPage = "/about.jsp";
                break;

            default:
                request.setAttribute("msg", "不明なコマンドです: " + detected);
                nextPage = "/index.html"; 
                break;
        }

        // JSP へ遷移（サーバー内で移動）
        request.getRequestDispatcher(nextPage).forward(request, response);
    }

}
