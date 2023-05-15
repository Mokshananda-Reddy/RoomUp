import React from 'react';
import { render, screen} from '@testing-library/react';
import { MemoryRouter} from "react-router-dom";
import Pagebar from "../../components/pagebaraddblock/Pagebaraddblock";
import '@testing-library/jest-dom/extend-expect';


test('renders block managers in pagebar', () => {
    render(<MemoryRouter><Pagebar /></MemoryRouter>);
    const block = screen.getByText((content) => {
      return content.includes('Block Managers');
    });
    expect(block).toBeInTheDocument();
});

test('renders add a block manager in pagebar', () => {
    render(<MemoryRouter><Pagebar /></MemoryRouter>);
    const newblock = screen.getByText((content) => {
      return content.includes('Add a New Block Manager');
    });
    expect(newblock).toBeInTheDocument();
});