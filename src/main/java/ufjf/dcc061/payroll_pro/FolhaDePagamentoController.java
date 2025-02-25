package ufjf.dcc061.payroll_pro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/folhaPagamento")
public class FolhaDePagamentoController {

    @Autowired
    private FolhaDePagamentoRepository folhaRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    // Listar todas as folhas de pagamento
    @GetMapping
    public String listarFolhas(Model model) {
        model.addAttribute("folhas", folhaRepository.findAll());
        return "folhaPagamento/lista";
    }

    // Exibir formulário para nova folha de pagamento
    @GetMapping("/novo")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("folha", new FolhaDePagamento());
        model.addAttribute("colaboradores", colaboradorRepository.findAll());
        return "folhaPagamento/form";
    }

    // Salvar folha de pagamento
    @PostMapping
    public String salvarFolha(@ModelAttribute FolhaDePagamento folha, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("colaboradores", colaboradorRepository.findAll());
            return "folhaPagamento/form";
        }
        folhaRepository.save(folha);
        return "redirect:/folhaPagamento";
    }

    // Exibir formulário de edição
    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable("id") Long id, Model model) {
        FolhaDePagamento folha = folhaRepository.findById(id).orElse(null);
        if (folha == null) {
            return "redirect:/folhaPagamento";
        }
        model.addAttribute("folha", folha);
        model.addAttribute("colaboradores", colaboradorRepository.findAll());
        return "folhaPagamento/form";
    }

    // Atualizar folha de pagamento
    @PostMapping("/editar/{id}")
    public String atualizarFolha(@PathVariable("id") Long id, @ModelAttribute FolhaDePagamento folha,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("colaboradores", colaboradorRepository.findAll());
            return "folhaPagamento/form";
        }
        folha.setId(id);
        folhaRepository.save(folha);
        return "redirect:/folhaPagamento";
    }

    // Excluir folha de pagamento
    @GetMapping("/excluir/{id}")
    public String excluirFolha(@PathVariable("id") Long id) {
        folhaRepository.deleteById(id);
        return "redirect:/folhaPagamento";
    }
}
