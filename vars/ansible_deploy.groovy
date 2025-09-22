def call() {
    // Write playbooks from library resources
    writeFile file: 'deploy.yml', text: libraryResource('ansible/deploy.yml')
    writeFile file: 'aws_ec2.yml', text: libraryResource('ansible/aws_ec2.yml')

    // Run Ansible playbook
    sh "ansible-playbook -i aws_ec2.yml deploy.yml"
}
