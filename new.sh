#!/bin/bash
set -e

# Function to install dependencies for macOS
install_macos() {
    # Detect actual OS
    if [[ "$(uname)" != "Darwin" ]]; then
        echo "Error: You selected macOS but your system is not macOS."
        exit 1
    fi

    echo "Checking if Python 3 is installed..."
    if ! command -v python3 &> /dev/null
    then
        echo "Python 3 not found. Installing Python 3..."
        brew install python
    else
        PYTHON_VERSION=$(python3 --version)
        echo "Python 3 is already installed. Version: $PYTHON_VERSION"
    fi

    echo "Checking if AWS CLI is installed..."
    if ! command -v aws &> /dev/null
    then
        echo "AWS CLI not found. Installing AWS CLI..."
        brew install awscli
    else
        echo "AWS CLI is already installed."
    fi

    echo "Checking if AWS CDK is installed..."
    if ! command -v cdk &> /dev/null
    then
        echo "AWS CDK not found. Installing AWS CDK globally..."
        npm install -g aws-cdk
    else
        echo "AWS CDK is already installed."
    fi

    echo "Verifying AWS CDK installation..."
    cdk --version

    echo "Installing Python dependencies if requirements.txt exists..."
    if [ -f "requirements.txt" ]; then
        python3 -m pip install -r requirements.txt
    fi

    echo "macOS environment setup completed."
}

# Function to install dependencies for Ubuntu Linux
install_ubuntu() {
    # Detect actual OS
    if [[ "$(uname)" != "Linux" ]]; then
        echo "Error: You selected Linux but your system is not Linux."
        exit 1
    fi

    echo "Updating package list..."
    sudo apt update -y

    echo "Checking if Python 3 is installed..."
    if ! command -v python3 &> /dev/null
    then
        echo "Python 3 not found. Installing Python 3..."
        sudo apt install -y python3 python3-pip
    else
        PYTHON_VERSION=$(python3 --version)
        echo "Python 3 is already installed. Version: $PYTHON_VERSION"
    fi

    echo "Checking if AWS CLI is installed..."
    if ! command -v aws &> /dev/null
    then
        echo "AWS CLI not found. Installing AWS CLI..."
        sudo apt install -y awscli
    else
        echo "AWS CLI is already installed."
    fi

    echo "Checking if AWS CDK is installed..."
    if ! command -v cdk &> /dev/null
    then
        echo "AWS CDK not found. Installing AWS CDK globally..."
        npm install -g aws-cdk
    else
        echo "AWS CDK is already installed."
    fi

    echo "Verifying AWS CDK installation..."
    cdk --version

    echo "Installing Python dependencies if requirements.txt exists..."
    if [ -f "requirements.txt" ]; then
        python3 -m pip install -r requirements.txt
    fi

    echo "Ubuntu Linux environment setup completed."
}

# Prompt user to choose OS
echo "Select your operating system:"
echo "1. macOS"
echo "2. Ubuntu Linux"
read -p "Enter your choice (1 or 2): " choice

if [ "$choice" -eq 1 ]; then
    install_macos
elif [ "$choice" -eq 2 ]; then
    install_ubuntu
else
    echo "Invalid choice. Exiting."
    exit 1
fi
