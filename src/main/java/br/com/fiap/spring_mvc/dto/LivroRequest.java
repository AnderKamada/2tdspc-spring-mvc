package br.com.fiap.spring_mvc.model
import br.com.fiap.spring_mvc.model.Categoria;
import java.math.BigDecimal;

@Data
public class LivroRequest(
        @NotBlank(message = "O titulo é obrigatorio")
        private String titulo;
        @NotBlank(message = "O autor é obrigatorio")
        @Size(min = 4, max = 150, message = "O nome do autor deve ter entre 4 a 150 caracteres")
        private String autor;
        @NotNull (message = "A categoria é obrigatoria")
        private Categoria categoria;
        @DecimalMin (value = 0.99, message = "O preço deve ser maior que R$ 0.99")
        private BigDecimal preco;
        @Pattern(regexp = "^970\\d{7}$|^970\\d{10}$", message = "O ISBN deve seguir o padrao internacional")
        private String isbn;
) {

}