Feature: Collect Wallet

  Scenario: On click should show list of wallets - WalletConnect, MetaMask, Phantom, Fortmatic, Trust etc

    Given Launch the app
    Then Page should display any of below List of Wallet
      | WalletConnect  |
      | MetaMask       |
      | Phantom        |
      | Fortmatic      |
      | Trust          |
