package ufjf.dcc061.payroll_pro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    // Exibe a página de login
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    // Processa o formulário de login
    @PostMapping("/login")
    public String login(@RequestParam String username,
            @RequestParam String password,
            HttpSession session,
            Model model) {
        // Credenciais padrão: admin / admin
        if ("admin".equals(username) && "admin".equals(password)) {
            session.setAttribute("user", username);
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Usuário ou senha inválidos");
            return "login";
        }
    }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
