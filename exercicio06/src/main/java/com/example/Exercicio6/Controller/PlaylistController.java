package com.example.Exercicio6.Controller;
import com.example.Exercicio6.Services.PlaylistService;
import com.example.Exercicio6.model.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios/{usuarioId}/playlists")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @PostMapping
    public ResponseEntity<Playlist> criarPlaylist(@PathVariable Long usuarioId, @RequestBody Playlist playlist) {
        Playlist novaPlaylist = playlistService.criarPlaylist(usuarioId, playlist);
        return ResponseEntity.status(201).body(novaPlaylist);
    }

    @GetMapping("/{playlistId}")
    public ResponseEntity<Playlist> getPlaylist(@PathVariable Long usuarioId, @PathVariable Long playlistId) {
        Playlist playlist = playlistService.getPlaylist(usuarioId, playlistId);
        return ResponseEntity.ok(playlist);
    }

    @PatchMapping("/{playlistId}")
    public ResponseEntity<Playlist> atualizarPlaylist(@PathVariable Long usuarioId, @PathVariable Long playlistId, @RequestBody Playlist playlist) {
        Playlist playlistAtualizada = playlistService.atualizarPlaylist(usuarioId, playlistId, playlist);
        return ResponseEntity.ok(playlistAtualizada);
    }

    @DeleteMapping("/{playlistId}")
    public ResponseEntity<Void> deletarPlaylist(@PathVariable Long usuarioId, @PathVariable Long playlistId) {
        playlistService.deletarPlaylist(usuarioId, playlistId);
        return ResponseEntity.noContent().build();
    }
}
