package io.uric.cesta.gui;

import io.uric.cesta.pessoas.Beneficiario;
import io.uric.cesta.pessoas.Doador;
import io.uric.cesta.pessoas.Pessoa;
import io.uric.cesta.registroDoacoes.Registro;
import io.uric.cesta.registroDoacoes.TipoRegistro;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MainWindow{
    private static List<Beneficiario> beneficiarios = new ArrayList<Beneficiario>();
    private static List<Doador> doadores = new ArrayList<Doador>();
    private static List<Registro> operacoes= new ArrayList<Registro>();
    public JPanel generalPanel;
    private JTabbedPane GeneralTabs;
    private JPanel Header;
    private JPanel RegistroTab;
    private JPanel DoadorTab;
    private JPanel BeneficiarioTab;
    private JPanel RelatorioTab;
    private JTabbedPane RegistroPanelTabs;
    private JPanel RegAdicionarTab;
    private JPanel RegRemoverTab;
    private JPanel RegVerTab;
    private JTabbedPane DoadoresPanelTabs;
    private JTabbedPane BeneficiariosPanelTabs;
    private JPanel BenAdicionarTab;
    private JPanel BenBuscarTab;
    private JPanel BenAlterarTab;
    private JPanel BenRemoverTab;
    private JPanel DoaAdicionarTab;
    private JPanel DoaBuscarTab;
    private JPanel DoaAlterarTab;
    private JPanel DoaRemoverTab;
    private JButton RegAddButton;
    private JRadioButton EntradaRadio;
    private JRadioButton SaidaRadio;
    private JComboBox ListaPessoaCombo;
    private JTextField VRegPessoaField;
    private JTextField VRegDataField;
    private JTextField VRegQtdField;
    private JTextField RRegNomeField;
    private JTextField RRegDataField;
    private JTextField RRegQtdField;
    private JButton RegRemoverButton;
    private JButton DoaAddButton;
    private JButton DoaAlterarButton;
    private JButton DoaRemoverButton;
    private JButton BenAddButton;
    private JButton BenAlterarButton;
    private JButton BenRemoverButton;
    private JTextField ADoaNomeField;
    private JTextField ADoaCPFField;
    private JTextField ADoaTelField;
    private JComboBox VDoaCPFCombo;
    private JTextField VDoaNomeField;
    private JTextField VDoaDataField;
    private JTextField VDoaTelField;
    private JComboBox AltDoaCPFCombo;
    private JTextField AltDoaNomeField;
    private JTextField AltDoaTelField;
    private JComboBox RDoaCPFCombo;
    private JTextField RDoaNomeField;
    private JTextField RDoaDataField;
    private JTextField RDoaTelField;
    private JTextField ABenNomeField;
    private JTextField ABenCPFField;
    private JTextField ABenEndField;
    private JComboBox VBenCPFCombo;
    private JTextField VBenNomeField;
    private JTextField VBenDataField;
    private JTextField VBenFamiliaField;
    private JTextField VBenEndField;
    private JTextField VBenLastField;
    private JTextField VBenQtdField;
    private JComboBox AltBenCPFCombo;
    private JTextField AltBenNomeField;
    private JTextField AltBenEndField;
    private JSpinner AltBenFamiliaSpin;
    private JSpinner AltBenDataSpin;
    private JSpinner ABenDataSpin;
    private JSpinner ABenAnoSpin;
    private JSpinner AltDoaDataSpin;
    private JSpinner ADoaDataSpin;
    private JSpinner RRegIdSpin;
    private JSpinner QtdCestaSpin;
    private JSpinner VRegIdSpin;
    private JSpinner ABenFamiliaSpin;
    private JComboBox RBenCPFCombo;
    private JTextField RBenDataField;
    private JTextField RBenNomeField;
    private JTextField RBenEndField;
    private JTextField RBenFamilaField;
    private JTextField RBenLastField;
    private JButton RelRegButton;
    private JButton RelDoaButton;
    private JButton RelBenButton;
    private JLabel TipoPessoaLabel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    private static LocalDate dateToLocalDate(Date data){
        return data.toInstant().atZone( ZoneId.systemDefault() ).toLocalDate();
    }
    private static Date localDateToDate(LocalDate localDate){
        return Date.from( localDate.atStartOfDay( ZoneId.systemDefault() ).toInstant() );
    }
    private void configurarDataSpinners(){
        Calendar calendar = Calendar.getInstance();
        Date initDate = calendar.getTime();
        calendar.add(Calendar.YEAR, -100);
        Date earliestDate = calendar.getTime();
        SpinnerModel model = new SpinnerDateModel(initDate,earliestDate,initDate,Calendar.YEAR);
        ABenDataSpin.setModel(model);
        ABenDataSpin.setEditor(new JSpinner.DateEditor(ABenDataSpin, "dd/MM/yyyy"));
        ADoaDataSpin.setModel(model);
        ADoaDataSpin.setEditor(new JSpinner.DateEditor(ABenDataSpin, "dd/MM/yyyy"));
        AltBenDataSpin.setModel(model);
        AltBenDataSpin.setEditor(new JSpinner.DateEditor(ABenDataSpin, "dd/MM/yyyy"));
        AltDoaDataSpin.setModel(model);
        AltDoaDataSpin.setEditor(new JSpinner.DateEditor(ABenDataSpin, "dd/MM/yyyy"));
    }
    private void configurarNumberSpinners(){
        SpinnerModel model = new SpinnerNumberModel(1,1,null,1);
        QtdCestaSpin.setModel(model);
        ABenFamiliaSpin.setModel(model);
    }
    private void atualizarListaDoadores(){
        List<String> atDoador = doadores.stream().map(doador -> doador.getCpf()).collect(Collectors.toList());
        ComboBoxModel<String> modelAtDoador = new DefaultComboBoxModel<String>(atDoador.toArray(new String[0]));
        VDoaCPFCombo.setModel(modelAtDoador);
        AltDoaCPFCombo.setModel(modelAtDoador);
        RDoaCPFCombo.setModel(modelAtDoador);
    }
    private void atualizarListaBeneficiarios(){
        List<String> atBeneficiario = beneficiarios.stream().map(beneficiario -> beneficiario.getCpf()).collect(Collectors.toList());
        ComboBoxModel<String> modelAtBeneficiario = new DefaultComboBoxModel<String>(atBeneficiario.toArray(new String[0]));
        VBenCPFCombo.setModel(modelAtBeneficiario);
        AltBenCPFCombo.setModel(modelAtBeneficiario);
        RBenCPFCombo.setModel(modelAtBeneficiario);
    }
    private static LocalDate converterData(String data){
        return LocalDate.parse(data, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

    }
    private static Doador filterDoador(String cpf){
        List<Doador> filtrados = doadores.stream().filter(doador -> (doador.getCpf().equals(cpf))).collect(Collectors.toList());
        return filtrados.get(0);
    }
    private static Beneficiario filterBeneficiario(String cpf){
        List<Beneficiario> filtrados = beneficiarios.stream().filter(beneficiario -> (beneficiario.getCpf().equals(cpf))).collect(Collectors.toList());
        return filtrados.get(0);
    }
    private static boolean existeCPF(String cpf){
        List filtrados = doadores.stream().filter(doador -> (doador.getCpf().equals(cpf))).collect(Collectors.toList());
        if (filtrados.size()>=1) return true;
        filtrados = beneficiarios.stream().filter(beneficiario -> (beneficiario.getCpf().equals(cpf))).collect(Collectors.toList());
        if (filtrados.size()>=1) return true;
        return false;
    }
    private static void popularTeste(){
        doadores.add(
                new Doador(
                        0,
                        "Jão",
                        "1212731938",
                        converterData("29-02-1992"),
                        "219731313",
                        1
                )
        );
        beneficiarios.add(new Beneficiario(
                        "Augusto dos Anjos",
                        "12314584596",
                        converterData("22-03-1992"),
                        "Rua Testes do Fim do mundo",
                        1,
                        4,
                        converterData("11-06-2020"),
                        2
                )
        );
        operacoes.add(new Registro(
                0,
                doadores.get(0),
                TipoRegistro.ENTRADA,
                3
        ));
        operacoes.add(new Registro(
                1,
                beneficiarios.get(0),
                TipoRegistro.SAIDA,
                3
        ));
    }
    public MainWindow(boolean falseData) {
        if (falseData){
        popularTeste();
        }
        configurarDataSpinners();
        atualizarListaDoadores();
        atualizarListaBeneficiarios();
        configurarNumberSpinners();
        //Telas do Registro
        EntradaRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SaidaRadio.setSelected(false);
                List<String> atDoador = doadores.stream().map(doador -> doador.getCpf()).collect(Collectors.toList());
                ComboBoxModel<String> modelAtDoador = new DefaultComboBoxModel<String>(atDoador.toArray(new String[0]));
                ListaPessoaCombo.setModel(modelAtDoador);
                TipoPessoaLabel.setText("Doador");
                QtdCestaSpin.setValue(1);
            }
        });
        SaidaRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                EntradaRadio.setSelected(false);
                List<String> atBeneficiario = beneficiarios.stream().map(beneficiario -> beneficiario.getCpf()).collect(Collectors.toList());
                ComboBoxModel<String> modelAtBeneficiario = new DefaultComboBoxModel<String>(atBeneficiario.toArray(new String[0]));
                ListaPessoaCombo.setModel(modelAtBeneficiario);
                TipoPessoaLabel.setText("Beneficiario");
                QtdCestaSpin.setValue(1);
            }
        });
        ListaPessoaCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                RegAddButton.setEnabled(true);
            }
        });
        RegAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                List<Pessoa> selected = new ArrayList<Pessoa>();
                if (EntradaRadio.isSelected())
                {
                    selected.add(filterDoador(ListaPessoaCombo.getSelectedItem().toString()));
                } else {
                    selected.add(filterBeneficiario(ListaPessoaCombo.getSelectedItem().toString()));
                }

                operacoes.add(
                        new Registro(
                                (operacoes.size()>=1)?operacoes.get(operacoes.size()-1).getIdReg()+1:0,
                                selected.get(0),
                                EntradaRadio.isSelected()? TipoRegistro.ENTRADA:TipoRegistro.SAIDA,
                                (Integer) QtdCestaSpin.getValue()
                        )
                );
                EntradaRadio.setSelected(false);
                SaidaRadio.setSelected(false);
                ListaPessoaCombo.removeAll();
                TipoPessoaLabel.setText("Individuo:");
                QtdCestaSpin.setValue(1);
                RegAddButton.setEnabled(false);


            }
        });
        VRegIdSpin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                VRegPessoaField.setText(operacoes.get((Integer) VRegIdSpin.getValue()).getPessoa().getCpf());
                VRegDataField.setText(operacoes.get((Integer) VRegIdSpin.getValue()).getDataOperacao().toString());
                VRegQtdField.setText(Integer.toString(operacoes.get((Integer) VRegIdSpin.getValue()).getQtd()));
            }
        });
        RRegIdSpin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {

                RRegNomeField.setText(operacoes.get((Integer) RRegIdSpin.getValue()).getPessoa().getCpf());
                RRegDataField.setText(operacoes.get((Integer) RRegIdSpin.getValue()).getDataOperacao().toString());
                RRegQtdField.setText(Integer.toString(operacoes.get((Integer) RRegIdSpin.getValue()).getQtd()));
            }
        });
        RegRemoverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                operacoes.remove(RRegIdSpin.getValue());
                RRegNomeField.setText("");
                RRegDataField.setText("");
                RRegQtdField.setText("");

            }
        });

        //Telas do Doador
        DoaAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if ((ADoaCPFField.getText().length()==11) && !existeCPF(ADoaCPFField.getText())) {
                    doadores.add(new Doador(
                            doadores.get(doadores.size()-1).getIdDoador()+1,
                            ADoaNomeField.getText(),
                            ADoaCPFField.getText(),
                            dateToLocalDate((Date) ADoaDataSpin.getValue()),
                            ADoaTelField.getText(),
                            0
                    ));
                    ADoaCPFField.setText("");
                    ADoaNomeField.setText("");
                    ADoaTelField.setText("");
                    ADoaDataSpin.setValue(new Date());
                }
                ADoaCPFField.setText("");
                atualizarListaDoadores();
            }
        });
        VDoaCPFCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Doador selectedDoador = filterDoador(VDoaCPFCombo.getSelectedItem().toString());
                VDoaNomeField.setText(selectedDoador.getNome());
                VDoaDataField.setText(selectedDoador.getDataNascimento()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))); //Corrigir a exibição
                VDoaTelField.setText(selectedDoador.getTelefone());
            }
        });
        AltDoaCPFCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               Doador selectedDoador = filterDoador(AltDoaCPFCombo.getSelectedItem().toString());
               AltDoaNomeField.setText(selectedDoador.getNome());
               AltDoaDataSpin.setValue(localDateToDate(selectedDoador.getDataNascimento()));
               AltDoaTelField.setText(selectedDoador.getTelefone());
               DoaAlterarButton.setEnabled(true);
               atualizarListaDoadores();
            }
        });
        DoaAlterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){

                Doador selectedDoador = filterDoador(AltDoaCPFCombo.getSelectedItem().toString());
                int position = doadores.indexOf(selectedDoador);
                selectedDoador.setNome(AltDoaNomeField.getText());
                selectedDoador.setDataNascimento(dateToLocalDate((Date) AltDoaDataSpin.getValue()));
                selectedDoador.setTelefone(AltDoaTelField.getText());
                doadores.set(position,selectedDoador);
                AltDoaNomeField.setText("");
                AltDoaDataSpin.setValue(new Date());
                AltDoaTelField.setText("");
                AltDoaCPFCombo.setSelectedIndex(0);
                DoaAlterarButton.setEnabled(false);
                atualizarListaBeneficiarios();
            }
        });
        RDoaCPFCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Doador selectedDoador = filterDoador(RDoaCPFCombo.getSelectedItem().toString());
                RDoaNomeField.setText(selectedDoador.getNome());
                RDoaDataField.setText(selectedDoador.getDataNascimento()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))); //Corrigir a exibição
                RDoaTelField.setText(selectedDoador.getTelefone());
                DoaRemoverButton.setEnabled(true);

            }
        });
        DoaRemoverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                Doador selectedDoador = filterDoador(RDoaCPFCombo.getSelectedItem().toString());
                doadores.remove(selectedDoador);
                RDoaNomeField.setText("");
                RDoaDataField.setText("");
                RDoaTelField.setText("");
                atualizarListaDoadores();
                RDoaCPFCombo.setSelectedItem(0);
                DoaRemoverButton.setEnabled(false);
                atualizarListaDoadores();
            }
        });
        //Telas do Beneficiario
        BenAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (ABenFamiliaSpin.getValue().equals(0)) ABenFamiliaSpin.setValue(1);

                if ((ABenCPFField.getText().length()==11) && !existeCPF(ABenCPFField.getText())) {
                    beneficiarios.add(new Beneficiario(
                            ABenNomeField.getText(),
                            ABenCPFField.getText(),
                            dateToLocalDate((Date) ABenDataSpin.getValue()),
                            ABenEndField.getText(),
                            beneficiarios.get(beneficiarios.size()-1).getIdBeneficiario()+1,
                            (Integer) ABenFamiliaSpin.getValue(),
                            LocalDate.now(),
                            1
                    ));
                    ABenNomeField.setText("");
                    ABenCPFField.setText("");
                    ABenDataSpin.setValue(new Date());
                    ABenEndField.setText("");
                    ABenFamiliaSpin.setValue(1);
                    atualizarListaBeneficiarios();
                }
            }
        });
        VBenCPFCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Beneficiario selectedBeneficiario = filterBeneficiario(VBenCPFCombo.getSelectedItem().toString());
                VBenNomeField.setText(selectedBeneficiario.getNome());
                VBenDataField.setText(selectedBeneficiario.getDataNascimento()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))); //Corrigir a exibição
                VBenEndField.setText(selectedBeneficiario.getEndereco());
                VBenFamiliaField.setText(Integer.toString(selectedBeneficiario.getNumPessoasNaFamilia()));
                VBenLastField.setText(selectedBeneficiario.getUltimaCestaRecebida()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                VBenQtdField.setText(selectedBeneficiario.getProximaCesta()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
        });
        AltBenCPFCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Beneficiario selectedBeneficiario = filterBeneficiario(AltBenCPFCombo.getSelectedItem().toString());
                AltBenNomeField.setText(selectedBeneficiario.getNome());
                AltBenDataSpin.setValue(localDateToDate(selectedBeneficiario.getDataNascimento())); //Corrigir a exibição
                AltBenEndField.setText(selectedBeneficiario.getEndereco());
                AltBenFamiliaSpin.setValue(selectedBeneficiario.getNumPessoasNaFamilia());
                BenAlterarButton.setEnabled(true);
            }
        });
        BenAlterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                Beneficiario selectedBeneficiario = filterBeneficiario(RBenCPFCombo.getSelectedItem().toString());
                int position = beneficiarios.indexOf(selectedBeneficiario);
                selectedBeneficiario.setNome(AltBenNomeField.getText());
                selectedBeneficiario.setDataNascimento(dateToLocalDate((Date) AltBenDataSpin.getValue()));
                selectedBeneficiario.setEndereco(AltBenEndField.getText());
                selectedBeneficiario.setNumPessoasNaFamilia((Integer) AltBenFamiliaSpin.getValue());
                selectedBeneficiario.exibirBeneficiario();
                beneficiarios.set(position,selectedBeneficiario);
                AltBenNomeField.setText("");
                AltBenDataSpin.setValue(new Date());
                AltBenEndField.setText("");
                AltBenFamiliaSpin.setValue(0);
                AltBenCPFCombo.setSelectedItem(0);
                BenAlterarButton.setEnabled(false);
                atualizarListaBeneficiarios();

            }
        });
        RBenCPFCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Beneficiario selectedBeneficiario = filterBeneficiario(RBenCPFCombo.getSelectedItem().toString());
                RBenNomeField.setText(selectedBeneficiario.getNome());
                RBenDataField.setText(selectedBeneficiario.getDataNascimento()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))); //Corrigir a exibição
                RBenEndField.setText(selectedBeneficiario.getEndereco());
                RBenFamilaField.setText(Integer.toString(selectedBeneficiario.getNumPessoasNaFamilia()));
                RBenLastField.setText(selectedBeneficiario.getUltimaCestaRecebida()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                RBenLastField.setText(selectedBeneficiario.getProximaCesta()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                BenRemoverButton.setEnabled(true);
            }
        });
        BenRemoverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){

                Beneficiario selectedBeneficiario = filterBeneficiario(RBenCPFCombo.getSelectedItem().toString());
                beneficiarios.remove(selectedBeneficiario);
                RBenNomeField.setText("");
                RBenDataField.setText("");
                RBenEndField.setText("");
                RBenFamilaField.setText("");
                RBenLastField.setText("");
                RBenLastField.setText("");
                atualizarListaBeneficiarios();
                RBenCPFCombo.setSelectedItem(0);
                BenRemoverButton.setEnabled(false);
            }
        });
        RelRegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                operacoes.stream().forEach(registro -> registro.listarDoacao());
            }
        });
        RelBenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                beneficiarios.stream().forEach(beneficiario -> beneficiario.exibirBeneficiario());
            }
        });
        RelDoaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                doadores.stream().forEach(doador -> doador.exibirDoador());
            }
        });

    }
}
