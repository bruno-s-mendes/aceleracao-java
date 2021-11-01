package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;
import br.com.codenation.models.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
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
        boolean playerCheck = Functions.existsPlayer(idJogador, players);
        if (!playerCheck) throw new JogadorNaoEncontradoException();
        long idTime = Functions.getTeamFromPlayer(idJogador, players);
		Functions.setCaptain(idTime, idJogador, teams);
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		boolean teamCheck = Functions.existsTeam(idTime, teams);
		if (!teamCheck) throw new TimeNaoEncontradoException();
		long captainId = Functions.getCapitain(idTime, teams);
		if (captainId == 0L)  throw new CapitaoNaoInformadoException();
		return captainId;
	}

	public String buscarNomeJogador(Long idJogador) {
		boolean playerCheck = Functions.existsPlayer(idJogador, players);
		if (!playerCheck) throw new JogadorNaoEncontradoException();
		String playerName = "";

		for (Player player : players) {
			if (player.getId() == idJogador) {
				playerName = player.getNome();
				break;
			}
		}
		return playerName;
	}

	public String buscarNomeTime(Long idTime) {
		boolean teamCheck = Functions.existsTeam(idTime, teams);
		if (!teamCheck) throw new TimeNaoEncontradoException();
		String teamName = "";

		for (Team team : teams) {
			if (team.getId() == idTime) {
				teamName = team.getNome();
				break;
			}
		}
		return teamName;
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
		boolean teamCheck = Functions.existsTeam(idTime, teams);
		if (!teamCheck) throw new TimeNaoEncontradoException();
		Integer bestSkill = 0;
		Long bestPlayerId = 0L;

		for (Player player : players) {
			if(Objects.equals(player.getIdTime(), idTime)){
				if (player.getNivelHabilidade() > bestSkill) {
					bestSkill = player.getNivelHabilidade();
					bestPlayerId = player.getId();
				}
			}
		}
		return bestPlayerId;
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		boolean teamCheck = Functions.existsTeam(idTime, teams);
		if (!teamCheck) throw new TimeNaoEncontradoException();
		LocalDate highAge = LocalDate.now();
		Long oldestPlayerId = 999999999999999999L;

		for (Player player : players) {
			if(Objects.equals(player.getIdTime(), idTime)){
				if (player.getDataNascimento().isBefore(highAge) & (player.getId() < oldestPlayerId)) {
					highAge = player.getDataNascimento();
					oldestPlayerId = player.getId();
				}
			}
		}
		return oldestPlayerId;
	}

	public List<Long> buscarTimes() {
		List<Long> idList = new ArrayList<>();
		for (Team team : teams) {
			idList.add(team.getId());
		}
		return idList.stream().sorted().collect(Collectors.toList());
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		boolean teamCheck = Functions.existsTeam(idTime, teams);
		if (!teamCheck) throw new TimeNaoEncontradoException();
		BigDecimal hiestSalary = new BigDecimal(0);
		Long richestPlayerId = 0L;

		for (Player player : players) {
			if(Objects.equals(player.getIdTime(), idTime)){
				if ((player.getSalario().compareTo(hiestSalary) > 0) & (player.getId() > richestPlayerId)) {
					hiestSalary = player.getSalario();
					richestPlayerId = player.getId();
				}
			}
		}
		return richestPlayerId;
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		boolean playerCheck = Functions.existsPlayer(idJogador, players);
		if (!playerCheck) throw new JogadorNaoEncontradoException();
		BigDecimal salary = new BigDecimal(0);

		for (Player player : players) {
			if (player.getId() == idJogador) {
				salary = player.getSalario();
				break;
			}
		}
		return salary;
	}

	public List<Long> buscarTopJogadores(Integer top) {
		if (players.isEmpty()) return Collections.emptyList();
		List<Player> ordered =  players.stream().sorted(Comparator.comparingInt(Player::getNivelHabilidade)).collect(Collectors.toList());
		int size = ordered.size();
		List<Long> idList = new ArrayList<>();

		for (int i = 0; i < top; i++) {
			idList.add(players.get((players.size() -1 - i)).getId());
		}
		return idList;
	}
}
