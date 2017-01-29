package me.reyad.spongetutorial

import com.google.inject.Inject
import org.slf4j.Logger
import org.spongepowered.api.entity.living.player.Player
import org.spongepowered.api.event.Listener
import org.spongepowered.api.event.filter.Getter
import org.spongepowered.api.event.game.state.GameStartedServerEvent
import org.spongepowered.api.event.network.ClientConnectionEvent
import org.spongepowered.api.plugin.Plugin
import org.spongepowered.api.text.Text
import org.spongepowered.api.text.format.TextColors
import org.spongepowered.api.text.format.TextStyles

@Plugin(id = "spongetutorial", name = "SpongeTutorial")
class SpongeTutorial {

    @Inject
    private val logger: Logger? = null


    @Listener
    fun onServerStart(event: GameStartedServerEvent) {
        // Hey! The server has started!
        this.logger!!.info("Hello world!")
        // Try loading some configuration settings for a welcome message to players
        // when they join!
    }


    @Listener
    fun onPlayerJoin(event: ClientConnectionEvent.Join, @Getter("getTargetEntity") player: Player) {
        // The text message could be configurable, check the docs on how to do so!
        player.sendMessage(Text.of(TextColors.AQUA, TextStyles.BOLD, "Hi " + player.name))
    }

}
