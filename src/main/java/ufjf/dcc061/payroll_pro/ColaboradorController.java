package ufjf.dcc061.payroll_pro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    // Listar todos os colaboradores
    @GetMapping
    public String listarColaboradores(Model model) {
        model.addAttribute("colaboradores", colaboradorRepository.findAll());
        return "colaboradores/lista";
    }

    // Exibir formulário para novo colaborador
    @GetMapping("/novo")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("colaborador", new Colaborador());
        return "colaboradores/form";
    }

    // Salvar novo colaborador
    @PostMapping
    public String salvarColaborador(@ModelAttribute Colaborador colaborador, BindingResult result) {
        if (result.hasErrors()) {
            return "colaboradores/form";
        }
        colaboradorRepository.save(colaborador);
        return "redirect:/colaboradores";
    }

    // Exibir formulário de edição
    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable("id") Long id, Model model) {
        Colaborador colaborador = colaboradorRepository.findById(id).orElse(null);
        if (colaborador == null) {
            return "redirect:/colaboradores";
        }
        model.addAttribute("colaborador", colaborador);
        return "colaboradores/form";
    }

    // Atualizar colaborador
    @PostMapping("/editar/{id}")
    public String atualizarColaborador(@PathVariable("id") Long id, @ModelAttribute Colaborador colaborador,
            BindingResult result) {
        if (result.hasErrors()) {
            return "colaboradores/form";
        }
        colaborador.setId(id);
        colaboradorRepository.save(colaborador);
        return "redirect:/colaboradores";
    }

    // Excluir colaborador
    @GetMapping("/excluir/{id}")
    public String excluirColaborador(@PathVariable("id") Long id) {
        colaboradorRepository.deleteById(id);
        return "redirect:/colaboradores";
    }
}
