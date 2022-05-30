Feature: Social Media

  Scenario: Social Media Link redirection

    Given Launch the app
    Then Check Social Media Links
      | Social Media | Title                               | url                                                              |
      | Telegram     | Telegram: Contact @junglenft        | https://t.me/junglenft                                           |
      | Twitter      | Jungle (@Junglenftmarket) / Twitter | https://twitter.com/Junglenftmarket                              |
      | Discord      | Jungle NFT Marketplace Official     | https://discord.com/invite/tQzEMNhMfV                            |
      | Instagram    | Log in • Instagram                  | https://www.instagram.com/accounts/login/?next=/junglenftmarket/ |
      | Facebook     | Jungle - Home                       | https://www.facebook.com/junglenft/                              |
      | Linkedin     | ungle \| LinkedIn                   | https://www.linkedin.com/company/junglenft/                      |