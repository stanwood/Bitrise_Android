# Bitrise_Android
Unofficial Bitrise client for Android

Develop: <img src="https://www.bitrise.io/app/8690e88b0025eabb/status.svg?token=eh7elLjmVEJnif_1HDgt1Q&branch=develop"/>

Master: <img src="https://www.bitrise.io/app/8690e88b0025eabb/status.svg?token=eh7elLjmVEJnif_1HDgt1Q&branch=master"/>

## Screenshots

<img src="/docs/assets/screenshot_login.png" width="20%"><img src="/docs/assets/screenshot_apps.png" width="20%"><img src="/docs/assets/screenshot_artifacts.png" width="20%"><img src="/docs/assets/screenshot_logs.png" width="20%"><img src="/docs/assets/screenshot_builds.png" width="20%">

## Token

If you don't want to fill out the token on your phone you can provide it in the `local.properties` file like so:

```groovy
bitrise.api.token=YourBitriseTokenHere
```

You can obtain a token from [here](https://www.bitrise.io/me/profile#/security).

This fills in the token value as stored in `local.properties` as default into the token input during login.
_Note, that currently you're loosing the ability to logout when doing that._