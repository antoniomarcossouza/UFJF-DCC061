package ufjf.dcc061.payroll_pro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dependentes")
public class DependenteController {

    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    // Listar todos os dependentes
    @GetMapping
    public String listarDependentes(Model model) {
        model.addAttribute("dependentes", dependenteRepository.findAll());
        return "dependentes/lista";
    }

    // Exibir formulário para novo dependente
    @GetMapping("/novo")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("dependente", new Dependente());
        // Adiciona a lista de colaboradores para seleção no formulário
        model.addAttribute("colaboradores", colaboradorRepository.findAll());
        return "dependentes/form";
    }

    // Salvar novo dependente
    @PostMapping
    public String salvarDependente(@ModelAttribute Dependente dependente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("colaboradores", colaboradorRepository.findAll());
            return "dependentes/form";
        }
        dependenteRepository.save(dependente);
        return "redirect:/dependentes";
    }

    // Exibir formulário de edição
    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable("id") Long id, Model model) {
        Dependente dependente = dependenteRepository.findById(id).orElse(null);
        if (dependente == null) {
            return "redirect:/dependentes";
        }
        model.addAttribute("dependente", dependente);
        model.addAttribute("colaboradores", colaboradorRepository.findAll());
        return "dependentes/form";
    }

    // Atualizar dependente
    @PostMapping("/editar/{id}")
    public String atualizarDependente(@PathVariable("id") Long id, @ModelAttribute Dependente dependente,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("colaboradores", colaboradorRepository.findAll());
            return "dependentes/form";
        }
        dependente.setId(id);
        dependenteRepository.save(dependente);
        return "redirect:/dependentes";
    }

    // Excluir dependente
    @GetMapping("/excluir/{id}")
    public String excluirDependente(@PathVariable("id") Long id) {
        dependenteRepository.deleteById(id);
        return "redirect:/dependentes";
    }
}
