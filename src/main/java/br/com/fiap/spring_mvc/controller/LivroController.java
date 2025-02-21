package br.com.fiap.spring_mvc.controller

import br.com.fiap.spring_mvc.dto.LivroRequest;
import org.springframework.stereotype.Controller;
import org.springframework.we.bind.annotation.GetMapping;
import org.springframework.we.bind.annotation.RequestMapping;
import org.springframework.we.servlet.ModelAndView;

@Controller
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    LivroService livroService;

     @GetMapping ("/cadastro")
     public ModelAndView livroCadastro() {
         ModelAndView mv =new ModelAndView("livroCadastro");
         mv.addObject("livroRequest", new LivroRequest());
         return mv;
     }

@PostMapping("/cadastrar")
public ModelAndView cadastrarLivro(@Valid @ModelAttribute LivroRequest livroRequest) {
         //mapear livroRequest para livro
         // salvar livro no bd
    Livro livro = livroService.salvarLivro(livroRequest);
        //renderizar a pagina com a lista de livros cadastrados
    return listarLivros();
}

@GetMapping("/lista")
    public ModelAndView listarLivros() {
       return new ModelAndView("livroLista");

}
 }