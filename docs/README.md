# Bitrise_Android
Unofficial Bitrise client for Android

<a href='https://play.google.com/store/apps/details?id=io.stanwood.bitrise&pcampaignid=MKT-Other-global-all-co-prtnr-py-PartBadge-Mar2515-1'><img alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png' width="20%"/></a>

Develop: <img src="https://app.bitrise.io/app/8690e88b0025eabb/status.svg?token=eh7elLjmVEJnif_1HDgt1Q&branch=develop"/>

Master: <img src="https://app.bitrise.io/app/8690e88b0025eabb/status.svg?token=eh7elLjmVEJnif_1HDgt1Q&branch=master"/>

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
