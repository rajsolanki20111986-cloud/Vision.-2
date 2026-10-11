# 🚀 VISION - Marvel-Inspired Autonomous AI Assistant for Android

**Version 4.0.0** - Complete with all versions (v1, v2, v3, v4) integrated

---

## 📌 Overview

**Vision** is an autonomous AI assistant app for Android, inspired by Marvel's Vision. It runs on **Gemini Live API** (gemini-2.0-flash-exp) for intelligent audio-to-audio interaction and real-time decision-making.

### Key Features:
- ✅ **Autonomous Decision Making** - Never asks "क्या करूँ?", decides independently (confidence >70%)
- ✅ **Universal App Understanding** - Dynamically understands ANY app without hardcoding
- ✅ **100% Screen Reading** - Reads text, buttons, images, videos, game UI
- ✅ **Three Reading Modes** - On-Demand, Continuous, Real-Time (<50ms for games)
- ✅ **Game Control AI** - Tactical decisions in Free Fire, PUBG, etc.
- ✅ **Smart Notifications** - Auto-detect, auto-reply with context awareness
- ✅ **File & Code Management** - Create files, write code, GitHub integration
- ✅ **Hindi/Hinglish Native** - Natural communication in multiple languages
- ✅ **Proactive & Autonomous** - Anticipates needs, continues without asking

---

## 📂 Project Structure

```
Vision/
├── app/
│   ├── src/main/
│   │   ├── java/com/vision/app/
│   │   │   ├── v0_3/ (Original 12 stable files)
│   │   │   │   ├── Persona.kt
│   │   │   │   ├── AudioStreamer.kt
│   │   │   │   ├── LiveSession.kt
│   │   │   │   ├── VoiceService.kt
│   │   │   │   ├── VisionAccessibilityService.kt
│   │   │   │   ├── ToolRouter.kt
│   │   │   │   ├── ChatEngine.kt
│   │   │   │   ├── Prefs.kt
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── NotificationListener.kt
│   │   │   │   ├── LanguageDetector.kt
│   │   │   │   └── SystemPermissionTools.kt
│   │   │   │
│   │   │   └── v0_4/ (New 10 revolutionary files)
│   │   │       ├── UniversalAppUnderstanding.kt
│   │   │       ├── CompleteScreenReader.kt
│   │   │       ├── IntelligentDecisionMaker.kt
│   │   │       ├── GameControlSystem.kt
│   │   │       ├── UpdatedLiveSession.kt
│   │   │       ├── ImageRecognition.kt
│   │   │       ├── VideoUnderstanding.kt
│   │   │       ├── EnhancedNotificationManager.kt
│   │   │       ├── FileManagerIntegration.kt
│   │   │       └── Persona.kt (v4 updated)
│   │   │
│   │   ├── res/
│   │   │   ├── values/
│   │   │   │   └── strings.xml
│   │   │   └── ...other resources
│   │   │
│   │   └── AndroidManifest.xml
│   │
│   └── build.gradle
│
├── .github/
│   └── workflows/
│       └── build.yml (GitHub Actions for APK)
│
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
├── .gitignore
└── README.md
```

---

## 🔧 Setup & Build

### Prerequisites:
- Android SDK 21+ (minSdk)
- Android SDK 34 (compileSdk)
- JDK 11+
- Gradle 8.1.0+

### Clone & Build:

```bash
# Clone the repository
git clone https://github.com/YOUR_USERNAME/Vision.git
cd Vision

# Build with Gradle
./gradlew build

# Build APK
./gradlew assembleRelease
```

### Or use GitHub Actions:
- Push to `main` branch
- GitHub Actions automatically builds APK
- Download APK from Actions artifacts

---

## 📊 Versions Included

### Version 3.0 (Original - 12 files)
- ✅ Working audio interface
- ✅ Voice service with Gemini
- ✅ Accessibility service for screen reading
- ✅ Notification listener
- ✅ Language detection
- ✅ Chat engine
- ✅ System permissions handling
- ✅ Tool routing

### Version 4.0 (New - 10 files)
- ✅ **UniversalAppUnderstanding** - Dynamic app detection via Gemini
- ✅ **CompleteScreenReader** - 100% screen reading (text, images, videos, games)
- ✅ **IntelligentDecisionMaker** - Autonomous decisions, no asking
- ✅ **GameControlSystem** - Tactical AI for gaming
- ✅ **UpdatedLiveSession** - Main orchestration system
- ✅ **ImageRecognition** - Image analysis via Gemini
- ✅ **VideoUnderstanding** - Video detection & content analysis
- ✅ **EnhancedNotificationManager** - Smart notification handling
- ✅ **FileManagerIntegration** - File & code operations
- ✅ **Persona.kt (v4)** - Updated system prompts

---

## 🧠 Brain: Gemini Live API

Vision's intelligence comes from **Gemini 2.0 Flash Experimental**:
- Audio-to-audio conversational AI
- Real-time decision making
- Universal app understanding
- Game tactical analysis
- Content generation (code, files, messages)

---

## 🎯 How to Use

### On Your Phone:

1. **Extract the ZIP**
   - Extract this folder on your phone
   - You'll have a complete Android project

2. **Set Up GitHub (Optional)**
   - Create a new repository on GitHub
   - Upload this folder
   - GitHub Actions will build APK automatically

3. **Build Locally** (if you have Android Studio on PC)
   - Open this folder in Android Studio
   - Build → Build APK
   - Transfer APK to phone

4. **Install APK**
   - Transfer APK to phone
   - Install (may need to allow unknown sources)
   - Grant all permissions
   - Launch "Vision" app

---

## 🔐 Permissions Required

Vision needs these permissions to work:
- 🎤 **Microphone** - Voice input
- 📱 **Accessibility Service** - Screen reading
- 📲 **Notification Access** - Message detection
- 📁 **File Access** - Create/edit files
- 📹 **Camera** - Screen capture
- 🔇 **Audio** - Voice output
- 📡 **Internet** - Gemini API calls

---

## 🌍 Language Support

- ✅ **Hindi** - Natural communication
- ✅ **Hinglish** - Mixed Hindi-English
- ✅ **English** - Full support
- ✅ **Auto-detection** - Detects language automatically

---

## 🎮 Game Control Features

Vision can control games like:
- 🎯 **Free Fire** - Loot management, combat decisions, zone awareness
- 🎯 **PUBG** - Similar tactical AI
- 🎯 **Any Casual Game** - Adaptive AI based on game UI

---

## 📱 Android Version Support

- **Minimum SDK**: Android 5.1 (API 21)
- **Target SDK**: Android 14 (API 34)
- **Recommended**: Android 12+ for best experience

---

## 🔄 Update Cycle

- **v0.1-v0.3**: Stable, proven, on GitHub
- **v0.4**: Latest, with revolutionary features
- **Future**: Memory system, multimodal AI, offline support

---

## 📝 Credits

- **Creator**: Raj
- **Brain**: Gemini 2.0 Flash (Google)
- **Design Philosophy**: Marvel's Vision
- **Platform**: Android 5.1+

---

## 🚀 Quick Start

```bash
# 1. Extract this ZIP
unzip Vision-FINAL-ALL-VERSIONS.zip
cd Vision

# 2. Build APK
./gradlew assembleRelease

# 3. APK location
app/build/outputs/apk/release/app-release.apk

# 4. Install on phone
adb install app/build/outputs/apk/release/app-release.apk
```

---

## 📞 GitHub Push Instructions

```bash
# If you want to push to GitHub:

# 1. Create new repository on GitHub
# 2. Initialize Git
git init
git add .
git commit -m "Vision v4.0 - Complete autonomous AI assistant"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPO.git
git push -u origin main

# 3. GitHub Actions will automatically:
#    - Build the project
#    - Generate APK
#    - Make it available for download
```

---

## ⚠️ Important Notes

- ❌ **NO Hardcoded Apps** - Everything is dynamic via Gemini
- ❌ **NO Memory System** - Pure real-time processing
- ✅ **Fully Autonomous** - Makes decisions independently
- ✅ **Production Ready** - All features complete
- ✅ **GitHub Actions Ready** - Automatic APK generation

---

## 🎓 Learning Resources

- [Android Development](https://developer.android.com/)
- [Gemini API Docs](https://ai.google.dev/)
- [Kotlin Documentation](https://kotlinlang.org/docs/)

---

## 📜 License

This project is open source. Use, modify, and distribute freely.

---

## 🙏 Acknowledgments

- Google Gemini for intelligent AI
- Android community
- Raj for the vision

---

**Vision is not just an app. Vision is autonomous. Vision is intelligent. Vision is the future.**

*"I am Vision. I am complete. Ready to assist."*

---

**Version**: 4.0.0  
**Date**: 2026-10-11  
**Status**: ✅ Production Ready
