#!/bin/bash

# Exit immediately if any command fails
set -e

# Step 1: Check for Homebrew (macOS package manager)
echo "Checking if Homebrew is installed..."
if ! command -v brew &> /dev/null
then
    echo "Homebrew not found. Installing Homebrew..."
    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
else
    echo "Homebrew is already installed."
fi

# Step 2: Check if Python is installed (assuming you're using Python 3)
echo "Checking if Python 3 is installed..."
if ! command -v python3 &> /dev/null
then
    echo "Python 3 not found. Installing Python 3..."
    brew install python
else
    PYTHON_VERSION=$(python3 --version)
    echo "Python 3 is already installed. Version: $PYTHON_VERSION"
fi

# Step 3: Check if AWS CLI is installed
echo "Checking if AWS CLI is installed..."
if ! command -v aws &> /dev/null
then
    echo "AWS CLI not found. Installing AWS CLI..."
    brew install awscli
else
    echo "AWS CLI is already installed."
fi

# Step 4: Check if AWS CDK is installed globally
echo "Checking if AWS CDK is installed..."
if ! command -v cdk &> /dev/null
then
    echo "AWS CDK not found. Installing AWS CDK globally..."
    npm install -g aws-cdk
else
    echo "AWS CDK is already installed."
fi

# Step 5: Verify AWS CDK installation
echo "Verifying AWS CDK installation..."
cdk --version

# Step 6: Navigate to the CDK project directory (assuming the script is being run inside the CDK project)
echo "Navigating to the CDK project directory..."
cd "$(pwd)"

# Step 7: Install Python project dependencies (Assuming requirements.txt exists)
if [ -f "requirements.txt" ]; then
    echo "Python project detected. Installing dependencies with pip..."
    python3 -m pip install -r requirements.txt
else
    echo "No requirements.txt found. Skipping Python dependency installation."
fi

# Step 8: Final Message
echo "Environment setup completed successfully!"
echo "You can now run CDK commands such as 'cdk deploy', 'cdk diff', etc."
