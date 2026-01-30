#!/bin/bash

set -e



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

echo "Navigating to the CDK project directory..."
cd "$(pwd)"

if [ -f "requirements.txt" ]; then
    echo "Python project detected. Installing dependencies with pip..."
    python3 -m pip install -r requirements.txt
else
    echo "No requirements.txt found. Skipping Python dependency installation."
fi

echo "You can now run CDK commands such as 'cdk deploy', 'cdk diff', etc."
