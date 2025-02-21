package br.com.fiap.spring_mvc.service;

import br.com.fiap.spring_mvc.dto.LivroRequest;
import br.com.fiap.spring_mvc.model.Livro;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
    @Autowired
    LivroRepository livroRepository;

    public Livro salvarLivro(LivroRequest livro) {
        Livro livro = requestTolivro(livroRequest);
        return livroRepository.save(livro);
    }

    public Livro requestTolivro(LivroRequest livroRequest) {
        Livro livro = new Livro();
        BeanUtils.copyProperties(livroRequest, livro);
        livro.setTitulo(livroRequest.getTitulo());
        livro.setAutor(livroRequest.getAutor());
        livro.setCategoria(livroRequest.getCategoria());
        livro.setPreco(livroRequest.getPreco());
        livro.setIsbn(livroRequest.getIsbn());
        return livro;
    }

}