package com.vision.app.v0_4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * INTELLIGENT DECISION MAKER (v0.4)
 * 
 * Core Philosophy:
 * ❌ Never ask "क्या करूँ?" (what should I do?)
 * ✅ Analyze situation → Make intelligent decision → Execute
 * 
 * Real-time analysis of:
 * - Current screen state
 * - User's apparent intent
 * - Available context
 * - Resources & constraints
 * - Risk/reward assessment
 * 
 * Examples:
 * - Instagram opened → Infer messaging intent → Start composing message
 * - Chat opened → Understand conversation context → Reply intelligently
 * - Game control given → Analyze state → Make tactical decisions
 * - New notification → Decide: auto-reply or inform user
 */

data class DecisionContext(
    val currentScreen: DisplaySnapshot,
    val previousScreen: DisplaySnapshot?,
    val userIntent: String,
    val currentApp: AppInfo,
    val userProfile: UserProfile,
    val timestamp: Long = System.currentTimeMillis()
)

data class UserProfile(
    val preferences: Map<String, String>,
    val communicationStyle: String,  // formal, casual, friendly
    val responsePatterns: List<String>,
    val gameSkillLevel: String,  // beginner, intermediate, advanced
    val trustedContacts: List<String>
)

data class Decision(
    val action: String,
    val reasoning: String,
    val confidence: Float,
    val alternativeActions: List<String>,
    val riskLevel: String  // low, medium, high
)

class IntelligentDecisionMaker(
    private val screenReader: CompleteScreenReader,
    private val appUnderstanding: UniversalAppUnderstanding
) {
    
    private val decisionHistory = mutableListOf<Decision>()
    private var userProfile = UserProfile(
        preferences = mutableMapOf(),
        communicationStyle = "friendly",
        responsePatterns = emptyList(),
        gameSkillLevel = "intermediate",
        trustedContacts = emptyList()
    )
    
    /**
     * Make intelligent decision based on context
     * NO "what should I do?" - just decide and act
     */
    suspend fun makeDecision(
        context: DecisionContext
    ): Decision? = withContext(Dispatchers.Default) {
        
        return@withContext try {
            // 1. Infer user's intent
            val intent = inferUserIntent(context)
            
            // 2. Analyze current situation
            val situation = analyzeSituation(context)
            
            // 3. Generate possible actions
            val possibleActions = generatePossibleActions(intent, situation, context)
            
            // 4. Evaluate and choose best action
            val bestAction = evaluateAndChoose(possibleActions, context)
            
            // 5. Cache decision for learning
            decisionHistory.add(bestAction)
            
            bestAction
            
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
    
    /**
     * Infer what the user is trying to accomplish
     * Based on: opened app, screen state, history
     */
    private suspend fun inferUserIntent(context: DecisionContext): String {
        val appName = context.currentApp.appName
        val screenText = context.currentScreen.screenText
        
        // Analyze app and screen to infer intent
        return when {
            appName.contains("Instagram", ignoreCase = true) -> {
                if (screenText.contains("message", ignoreCase = true)) "send_message"
                else if (screenText.contains("post", ignoreCase = true)) "view_post"
                else "browse_instagram"
            }
            appName.contains("YouTube", ignoreCase = true) -> {
                if (screenText.contains("search", ignoreCase = true)) "search_video"
                else "watch_video"
            }
            appName.contains("Chat", ignoreCase = true) || 
            appName.contains("WhatsApp", ignoreCase = true) -> {
                "send_message"
            }
            appName.contains("File", ignoreCase = true) -> {
                if (screenText.contains("create", ignoreCase = true)) "create_file"
                else "browse_files"
            }
            else -> "generic_interaction"
        }
    }
    
    /**
     * Analyze current situation
     */
    private fun analyzeSituation(context: DecisionContext): Map<String, String> {
        return mapOf(
            "app" to context.currentApp.appName,
            "hasNewElements" to (context.previousScreen?.let {
                screenReader.detectChanges(it, context.currentScreen)
            }?.isNotEmpty()?.toString() ?: "false"),
            "clickableElements" to screenReader.getAllClickableElements().size.toString(),
            "userIntent" to context.userIntent
        )
    }
    
    /**
     * Generate possible actions based on intent and situation
     */
    private fun generatePossibleActions(
        intent: String,
        situation: Map<String, String>,
        context: DecisionContext
    ): List<Decision> {
        val possibleActions = mutableListOf<Decision>()
        
        when (intent) {
            "send_message" -> {
                possibleActions.add(Decision(
                    action = "look_for_chat_box",
                    reasoning = "User wants to send message, need to find input field",
                    confidence = 0.9f,
                    alternativeActions = listOf("search_contacts", "start_new_chat"),
                    riskLevel = "low"
                ))
                possibleActions.add(Decision(
                    action = "compose_message",
                    reasoning = "Chat interface is ready, compose message based on context",
                    confidence = 0.8f,
                    alternativeActions = listOf("wait_for_user_input"),
                    riskLevel = "low"
                ))
            }
            "search_video" -> {
                possibleActions.add(Decision(
                    action = "click_search_button",
                    reasoning = "User wants to search, click search field",
                    confidence = 0.95f,
                    alternativeActions = listOf("voice_search"),
                    riskLevel = "low"
                ))
            }
            "watch_video" -> {
                possibleActions.add(Decision(
                    action = "click_play_button",
                    reasoning = "Video visible, click play to start",
                    confidence = 0.9f,
                    alternativeActions = listOf("adjust_quality", "fullscreen"),
                    riskLevel = "low"
                ))
            }
            else -> {
                // Generic: look for main action button
                possibleActions.add(Decision(
                    action = "wait_for_command",
                    reasoning = "Unclear intent, wait for more context",
                    confidence = 0.5f,
                    alternativeActions = listOf("ask_user", "analyze_ui"),
                    riskLevel = "low"
                ))
            }
        }
        
        return possibleActions
    }
    
    /**
     * Evaluate actions and choose the best one
     */
    private suspend fun evaluateAndChoose(
        actions: List<Decision>,
        context: DecisionContext
    ): Decision {
        // For now, choose highest confidence
        // In future: consider risk, user preference, success history
        return actions.maxByOrNull { it.confidence } ?: actions.first()
    }
    
    /**
     * GAME CONTROL DECISION MAKING
     * Special logic for games like Free Fire
     */
    suspend fun makeGameDecision(
        gameState: GameState,
        context: DecisionContext
    ): String = withContext(Dispatchers.Default) {
        
        // Analyze game state
        val health = gameState.health
        val ammo = gameState.ammo
        val enemyCount = gameState.enemies.size
        val distanceToSafeZone = "unknown"  // Would calculate from minimap
        
        // Make tactical decision
        return@withContext when {
            // Emergency: low health and enemies nearby
            health < 30 && enemyCount > 0 -> {
                "flee_to_cover"
            }
            // Good opportunity: high ammo, health, enemies in range
            health > 60 && ammo > 50 && enemyCount > 0 -> {
                val enemy = gameState.enemies.first()
                when {
                    enemy.distance == "close" -> "engage_combat_headshot"
                    else -> "take_cover_and_shoot"
                }
            }
            // Resource gathering
            enemyCount == 0 && health < 75 -> {
                "loot_and_heal"
            }
            // Moving to safe zone
            else -> {
                "move_to_safe_zone"
            }
        }
    }
    
    /**
     * NOTIFICATION DECISION
     * Auto-reply or inform user?
     */
    suspend fun makeNotificationDecision(
        sender: String,
        messageContent: String
    ): NotificationDecision = withContext(Dispatchers.Default) {
        
        val isTrustedContact = userProfile.trustedContacts.contains(sender)
        val isUrgent = messageContent.contains(Regex("urgent|help|emergency|important", RegexOption.IGNORE_CASE))
        val isQuestion = messageContent.endsWith("?")
        
        return@withContext when {
            isUrgent -> {
                // Always inform for urgent messages
                NotificationDecision(
                    action = "inform_user",
                    message = "अरे, $sender का urgent message है!",
                    autoReply = null
                )
            }
            isTrustedContact && isQuestion && messageContent.length < 100 -> {
                // Auto-reply to questions from trusted contacts
                NotificationDecision(
                    action = "auto_reply",
                    message = "कुछ देर में reply दे दूंगा",
                    autoReply = "Thanks for your message! I'll get back to you shortly."
                )
            }
            else -> {
                // Inform user
                NotificationDecision(
                    action = "inform_user",
                    message = "$sender का message आया",
                    autoReply = null
                )
            }
        }
    }
    
    /**
     * Update user profile from interactions
     * Learn communication patterns
     */
    fun updateUserProfile(interaction: String, outcome: String) {
        // Learn from each decision
        // "User replied 'send it' when asked to confirm" → Next time, auto-send
        // "User prefers voice replies" → Always use voice
    }
    
    /**
     * Get decision history for learning
     */
    fun getDecisionHistory(): List<Decision> = decisionHistory
    
    /**
     * Clear history
     */
    fun clearHistory() {
        decisionHistory.clear()
    }
}

data class NotificationDecision(
    val action: String,  // inform_user, auto_reply, ignore
    val message: String,
    val autoReply: String?
)
