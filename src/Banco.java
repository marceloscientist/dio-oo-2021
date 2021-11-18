import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Banco {
    @Getter @Setter
    public String nome;
    public List<Conta> contas;
}
