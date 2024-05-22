package com.example.Exercicio6.Services;
import com.example.Exercicio6.Repository.PlaylistRepository;
import com.example.Exercicio6.Repository.UsuarioRepository;
import com.example.Exercicio6.model.Playlist;
import com.example.Exercicio6.model.Usuario;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Playlist criarPlaylist(Long usuarioId, Playlist playlist) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        playlist.setUsuario(usuario);
        return playlistRepository.save(playlist);
    }

    public Playlist getPlaylist(Long usuarioId, Long playlistId) {
        return playlistRepository.findByIdAndUsuarioId(playlistId, usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Playlist não encontrada"));
    }

    public Playlist atualizarPlaylist(Long usuarioId, Long playlistId, Playlist playlistAtualizada) {
        Playlist playlist = getPlaylist(usuarioId, playlistId);
        playlist.setNome(playlistAtualizada.getNome());
        playlist.setMusicas(playlistAtualizada.getMusicas());
        return playlistRepository.save(playlist);
    }

    public void deletarPlaylist(Long usuarioId, Long playlistId) {
        Playlist playlist = getPlaylist(usuarioId, playlistId);
        playlistRepository.delete(playlist);
    }
}