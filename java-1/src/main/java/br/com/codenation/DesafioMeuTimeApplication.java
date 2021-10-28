package br.com.codenation;

import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;
import br.com.codenation.models.Player;
import br.com.codenation.models.Players;
import br.com.codenation.models.Team;
import br.com.codenation.models.Teams;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class DesafioMeuTimeApplication implements MeuTimeInterface {

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		boolean teamCheck = Teams.existsTeam(id);
		if (teamCheck) throw new IdentificadorUtilizadoException();
		Team newTeam = new Team(id, nome, dataCriacao , corUniformePrincipal,  corUniformeSecundario);
		Teams.addTeam(newTeam);
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		boolean playerCheck = Players.existsPlayer(id);
		if (playerCheck) throw new IdentificadorUtilizadoException();
		boolean teamCheck = Teams.existsTeam(idTime);
		if (!teamCheck) throw new TimeNaoEncontradoException();
		Player newPlayer = new Player(id, idTime, nome , dataNascimento,  nivelHabilidade, salario);
		Players.addPlayer(newPlayer);
	}

	public void definirCapitao(Long idJogador) {
		throw new UnsupportedOperationException();
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public String buscarNomeJogador(Long idJogador) {
		throw new UnsupportedOperationException();
	}

	public String buscarNomeTime(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public List<Long> buscarTimes() {
		List<Long> idList = new ArrayList<>();
		List<Team> teams = Teams.getTeams();
		for (Team team : teams) {
			idList.add(team.getId());
		}
		return idList.stream().sorted().collect(Collectors.toList());
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		throw new UnsupportedOperationException();
	}

	public List<Long> buscarTopJogadores(Integer top) {
		throw new UnsupportedOperationException();
	}

}
