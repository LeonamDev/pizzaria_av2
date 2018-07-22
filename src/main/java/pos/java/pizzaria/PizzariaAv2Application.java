package pos.java.pizzaria;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pos.java.pizzaria.model.Atendente;
import pos.java.pizzaria.model.Categoria;
import pos.java.pizzaria.model.Cliente;
import pos.java.pizzaria.model.Endereco;
import pos.java.pizzaria.model.Gerente;
import pos.java.pizzaria.model.Ingrediente;
import pos.java.pizzaria.model.Motoboy;
import pos.java.pizzaria.model.Pedido;
import pos.java.pizzaria.model.Produto;
import pos.java.pizzaria.model.ProdutoPedido;
import pos.java.pizzaria.model.Role;
import pos.java.pizzaria.repository.AtendenteRepository;
import pos.java.pizzaria.repository.CategoriaRepository;
import pos.java.pizzaria.repository.ClienteRepository;
import pos.java.pizzaria.repository.EnderecoRepository;
import pos.java.pizzaria.repository.GerenteRepository;
import pos.java.pizzaria.repository.MotoboyRepository;
import pos.java.pizzaria.repository.PedidoRepository;
import pos.java.pizzaria.repository.ProdutoRepository;
import pos.java.pizzaria.repository.RoleRepository;

@SpringBootApplication
public class PizzariaAv2Application extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private GerenteRepository gerenteRepository;
    @Autowired
    private MotoboyRepository motoboyRepository;
    @Autowired
    private AtendenteRepository atendenteRepository;
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PizzariaAv2Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(PizzariaAv2Application.class, args);
        System.out.print(new BCryptPasswordEncoder().encode("123"));

    }

    @Override
    public void run(String... args) throws Exception {

        List<Categoria> categorias = new ArrayList();
        Categoria c1 = new Categoria("Empanados");
        Categoria c2 = new Categoria("Massas");
        categorias.add(c1);
        categorias.add(c2);

        List<Produto> produtos = new ArrayList();
        Produto p1 = new Produto(01, "Frango empanado", c1, 27);
        Produto p2 = new Produto(01, "Pizza de 6 queijos", c2, 20);
        produtos.add(p1);
        produtos.add(p2);

        Ingrediente i1 = new Ingrediente("Frango");
        Ingrediente i2 = new Ingrediente("Farinha de rosca");

        Ingrediente i3 = new Ingrediente("Queijo");
        Ingrediente i4 = new Ingrediente("Oregano");

        Cliente cliente = new Cliente(997979784, "Ricardo");
        Endereco endereco = new Endereco("Rua oliveiros", 17, "Perto do Shopping", cliente);

        p1.getIngredientes().add(i1);
        p1.getIngredientes().add(i2);

        p2.getIngredientes().add(i3);
        p2.getIngredientes().add(i4);

        Role gerenteRole = new Role("ROLE_GERENTE");
        Role atendenteRole = new Role("ROLE_ATENDENTE");

        Gerente gerente = new Gerente(159, "RafaelGerente", new BCryptPasswordEncoder().encode("123"), "Rafael");
        gerente.getRoles().add(gerenteRole);

        Motoboy entregador = new Motoboy("KXZ548", 584, "AugustoEntregador", new BCryptPasswordEncoder().encode("123"), "Augusto");

        Atendente atendente = new Atendente(159, 594, "RebecaAtendente", new BCryptPasswordEncoder().encode("123"), "Rebeca");
        atendente.getRoles().add(atendenteRole);

        List<Pedido> pedidos = new ArrayList();
        Pedido pedido = new Pedido(cliente, endereco, entregador, atendente, true, 23, 5, 70, 1, 10,
                new java.sql.Date(System.currentTimeMillis()), new java.sql.Timestamp(System.currentTimeMillis()), "PREPARANDO");
        Pedido pedido2 = new Pedido(cliente, endereco, entregador, atendente, true, 23, 5, 70, 2, 10,
                new java.sql.Date(System.currentTimeMillis()), new java.sql.Timestamp(System.currentTimeMillis()), "PREPARANDO");
        pedidos.add(pedido);
        pedidos.add(pedido2);

        ProdutoPedido produtoPedido = new ProdutoPedido(p1, pedido, 5, "Bem quente, por favor.");
        ProdutoPedido produtoPedido2 = new ProdutoPedido(p2, pedido, 7, "Com bastante queijo!");

        ProdutoPedido produtoPedido3 = new ProdutoPedido(p1, pedido2, 7, "Com bastante queijo!");
        ProdutoPedido produtoPedido4 = new ProdutoPedido(p2, pedido2, 7, "Com bastante queijo!");

        p1.getProdutoPedidos().add(produtoPedido);
        p2.getProdutoPedidos().add(produtoPedido2);

        p1.getProdutoPedidos().add(produtoPedido3);
        p2.getProdutoPedidos().add(produtoPedido4);

        for (Categoria categoria : categorias) {
            categoriaRepository.save(categoria);
        }

        clienteRepository.save(cliente);
        enderecoRepository.save(endereco);
        motoboyRepository.save(entregador);
        atendenteRepository.save(atendente);
        gerenteRepository.save(gerente);

        for (Pedido pedid : pedidos) {
            pedidoRepository.save(pedid);
        }

        for (Produto produto : produtos) {
            produtoRepository.save(produto);
        }

    }
}
