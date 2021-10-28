package br.com.codenation;

import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;
import br.com.codenation.models.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class DesafioMeuTimeApplication implements MeuTimeInterface {
		ArrayList<Team> teams = new ArrayList<>();
		ArrayList<Player> players = new ArrayList<>();
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		boolean teamCheck = Functions.existsTeam(id, teams);
		if (teamCheck) throw new IdentificadorUtilizadoException();
		Team newTeam = new Team(id, nome, dataCriacao , corUniformePrincipal,  corUniformeSecundario);
		teams.add(newTeam);
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		boolean playerCheck = Functions.existsPlayer(id, players);
		if (playerCheck) throw new IdentificadorUtilizadoException();
		boolean teamCheck = Functions.existsTeam(idTime, teams);
		if (!teamCheck) throw new TimeNaoEncontradoException();
		Player newPlayer = new Player(id, idTime, nome , dataNascimento,  nivelHabilidade, salario);
		players.add(newPlayer);
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
		boolean teamCheck = Functions.existsTeam(idTime, teams);
		if (!teamCheck) throw new TimeNaoEncontradoException();
		List<Long> teamPlayers = new ArrayList<>();
		for (Player player : players) {
			if(Objects.equals(player.getIdTime(), idTime)){
				teamPlayers.add(player.getId());
			}
		}
		return teamPlayers.stream().sorted().collect(Collectors.toList());
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public List<Long> buscarTimes() {
		List<Long> idList = new ArrayList<>();
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
