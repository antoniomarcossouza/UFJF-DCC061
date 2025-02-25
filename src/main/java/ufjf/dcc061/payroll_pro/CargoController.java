package ufjf.dcc061.payroll_pro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoRepository cargoRepository;

    // Listar todos os cargos
    @GetMapping
    public String listarCargos(Model model) {
        model.addAttribute("cargos", cargoRepository.findAll());
        return "cargos/lista";
    }

    // Exibir formulário para novo cargo
    @GetMapping("/novo")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("cargo", new Cargo());
        return "cargos/form";
    }

    // Salvar cargo
    @PostMapping
    public String salvarCargo(@ModelAttribute Cargo cargo, BindingResult result) {
        if (result.hasErrors()) {
            return "cargos/form";
        }
        cargoRepository.save(cargo);
        return "redirect:/cargos";
    }

    // Exibir formulário de edição
    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable("id") Long id, Model model) {
        Cargo cargo = cargoRepository.findById(id).orElse(null);
        if (cargo == null) {
            return "redirect:/cargos";
        }
        model.addAttribute("cargo", cargo);
        return "cargos/form";
    }

    // Atualizar cargo
    @PostMapping("/editar/{id}")
    public String atualizarCargo(@PathVariable("id") Long id, @ModelAttribute Cargo cargo, BindingResult result) {
        if (result.hasErrors()) {
            return "cargos/form";
        }
        cargo.setId(id);
        cargoRepository.save(cargo);
        return "redirect:/cargos";
    }

    // Excluir cargo
    @GetMapping("/excluir/{id}")
    public String excluirCargo(@PathVariable("id") Long id) {
        cargoRepository.deleteById(id);
        return "redirect:/cargos";
    }
}
