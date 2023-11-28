import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.main.models.CurriculoModel;
import com.project.main.repositories.CurriculoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CurriculoService {
    private final CurriculoRepository curriculoRepository;

    @Autowired
    public CurriculoService(CurriculoRepository curriculoRepository) {
        this.curriculoRepository = curriculoRepository;
    }

    public List<CurriculoModel> obterTodosOsCurriculos() {
        return curriculoRepository.findAll();
    }

    public Optional<CurriculoModel> obterCurriculoPorId(Long id) {
        return curriculoRepository.findById(id);
    }

    public List<CurriculoModel> obterCurriculosPorEmail(String email) {
        return curriculoRepository.findByEmail(email);
    }

    public void salvarCurriculo(CurriculoModel curriculo) {
        curriculoRepository.save(curriculo);
    }

    public void deletarCurriculo(Long id) {
        curriculoRepository.deleteById(id);
    }

}
