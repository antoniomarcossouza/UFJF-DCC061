package ufjf.dcc061.payroll_pro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColaboradorController {

    @Autowired
    ColaboradorRepository colaboradorRepository;

    @GetMapping("/colaboradores")
    public Iterable<Colaborador> getColaboradores() {
        return colaboradorRepository.findAll();
    }

}
